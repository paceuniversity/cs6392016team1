package cs639.midterm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText textDollars = (EditText)v.findViewById(R.id.txtInput);
        final TextView textFrancs = (TextView)v.findViewById(R.id.txtOutput);

        final Button btn = (Button)v.findViewById(R.id.btnConvert);

        textDollars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                textDollars.setText("");
            }
        });
        textDollars.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)){
                    btn.callOnClick();
                }

                return false;
            }
        });
        // Button btn = (Button)v.findViewById(R.id.btnConvert);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Double dDollars = Double.valueOf(textDollars.getText().toString());
                    Double dFrancs = convertFunds(dDollars);
                    textFrancs.setText(String.valueOf(String.format("%.2f", dFrancs)));
                }catch (NumberFormatException e){
                    Toast.makeText(v.getContext(), "Input must be numeric", Toast.LENGTH_LONG).show();
                }

            }
        });

        return v;
    }

    private double convertFunds(double inp){
        return inp*439.6;
    }
}
