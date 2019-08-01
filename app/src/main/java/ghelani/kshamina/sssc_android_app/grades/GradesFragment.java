package ghelani.kshamina.sssc_android_app.grades;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ghelani.kshamina.sssc_android_app.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GradesFragment extends Fragment {

    public GradesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grades, container, false);

        view.findViewById(R.id.excel_grade).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String url = "https://sssc.carleton.ca/sites/default/files/content-files/SSSC%20Grade%20and%20Mark%20Calculator%20Updated%20%28%2Bfinal%20exam%20grade%20calculator%29%20Updated%20Dec%202018_0.xlsx";
                String url2 = "https://sssc.carleton.ca/resources/succeeding#grades";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url2));
                startActivity(i);
            }
        });

        return view;
    }

}
