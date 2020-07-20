package ghelani.kshamina.sssc_android_app.ui.grades.terms.assignments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ghelani.kshamina.sssc_android_app.database.AssignmentDao;
import ghelani.kshamina.sssc_android_app.database.GradesDatabase;
import ghelani.kshamina.sssc_android_app.entity.Assignment;
import ghelani.kshamina.sssc_android_app.ui.common.events.ListItemEventListener;
import ghelani.kshamina.sssc_android_app.ui.common.list.ViewState;
import ghelani.kshamina.sssc_android_app.ui.common.list.model.ListItem;
import ghelani.kshamina.sssc_android_app.ui.grades.Grading;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AssignmentViewModel extends ViewModel {

    private AssignmentDao assignmentDao;
    private MutableLiveData<ViewState<ListItem>> state = new MutableLiveData<>();
    private boolean deleteMode;

    @Inject
    public AssignmentViewModel(GradesDatabase gradesDatabase) {
        super();
        this.assignmentDao = gradesDatabase.getAssignmentDao();
    }

    public void fetchCourseAssignments(String courseID) {
        assignmentDao.getAssignmentsByCourseId(courseID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Assignment>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Assignment> assignments) {
                        List<ListItem> assignmentItems = new ArrayList<>();
                        for (Assignment assignment : assignments) {
                            assignmentItems.add(createListItem(assignment));
                        }
                        state.setValue(new ViewState<>(false, false, true, "", assignmentItems));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private ListItem createListItem(Assignment assignment){
        int percentage = (int)((assignment.assignmentGradeEarned / assignment.assignmentGradeTotal)*100);
        return new ListItem(assignment.assignmentId, Grading.gradeToLetter.floorEntry(percentage).getValue(),
                assignment.assignmentName, String.valueOf(percentage),
                deleteMode, new ListItemEventListener() {
            @Override
            public void onItemClicked(String id) {

            }

            @Override
            public boolean onItemLongClicked(String id) {
                return false;
            }

            @Override
            public void toggleDeleteMode() {

            }

            @Override
            public void deleteItem(String courseId) {

            }
        });
    }

    public LiveData<ViewState<ListItem>> getState(){
        return state;
    }

    public boolean isDeleteMode() {
        return deleteMode;
    }

    public void setDeleteMode(boolean deleteMode) {
        this.deleteMode = deleteMode;
    }
}
