package dmusiolik.hornerschema_solver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public DecimalFormat df = new DecimalFormat("#.##");

    public void ausrechnen(View view) {

        TextView iks3 = (TextView) findViewById(R.id.editText);
        TextView iks2 = (TextView) findViewById(R.id.editText2);
        TextView iksx = (TextView) findViewById(R.id.editText3);
        TextView dezi = (TextView) findViewById(R.id.editText4);
        TextView startr = (TextView) findViewById(R.id.editText5);
        TextView stopr = (TextView) findViewById(R.id.editText6);

        TextView ausgabe = (TextView) findViewById(R.id.textView);

        CheckBox runden = (CheckBox) findViewById(R.id.checkBox);

        double ergebnis0 = 0;
        double ergebnis1 = 0;
        double x3 = Double.parseDouble(iks3.getText().toString());
        double x2 = Double.parseDouble(iks2.getText().toString());
        double x = Double.parseDouble(iksx.getText().toString());
        double dez = Double.parseDouble(dezi.getText().toString());
        double startrange = Integer.parseInt(startr.getText().toString());
        double stoprange = Integer.parseInt(stopr.getText().toString());

        //int range = 0;
        String nullstellen = "";

        double genauigkeit;

        if (runden.isChecked()) {
            genauigkeit = 1;
        }else{
            genauigkeit = 0.1;
        }


        for (int i = 0; startrange <= stoprange; startrange = startrange + genauigkeit) {

            ausgabe.setText(ausgabe.getText() + "Range: " + startrange + " ");
            ausgabe.setText(ausgabe.getText() + " " + x3 + " ");

            ergebnis0 = 0;
            ergebnis0 = (startrange * x3) + x2;

            ausgabe.setText(ausgabe.getText() + " " + ergebnis0 + " ");

            ergebnis1 = 0;
            ergebnis1 = (startrange * ergebnis0) + x;

            ausgabe.setText(ausgabe.getText() + " " + ergebnis1 + " ");

            ergebnis0 = 0;
            ergebnis0 = (startrange * ergebnis1) + dez;

            ausgabe.setText(ausgabe.getText() + " " + df.format(ergebnis0) + " \n");

            if (runden.isChecked()) {
                ergebnis1 = 0;
                ergebnis1 = Math.round(ergebnis0);
                if (ergebnis1 == 0) {
                    nullstellen = nullstellen + "\nNullstelle gefunden!\nRange: " + startrange + "\n\n";
                }
            }else{
                if (df.format(ergebnis0).startsWith("0.")) {
                    nullstellen = nullstellen + "\nNullstelle gefunden!\nRange: " + startrange + "\n\n";
                }
            }

        }

        ausgabe.setText(ausgabe.getText() + " " + nullstellen + "\n");

    }
}
