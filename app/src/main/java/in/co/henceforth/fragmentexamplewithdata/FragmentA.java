package in.co.henceforth.fragmentexamplewithdata;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    EditText editText;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        editText = (EditText) v.findViewById(R.id.valueA);


        Button btn = (Button) v.findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Fragment fr = new FragmentB();

                Bundle args = new Bundle();
                args.putString("value", editText.getText().toString());

                fr.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container_B, fr).commit();

            }
        });

        return v;
    }


}
