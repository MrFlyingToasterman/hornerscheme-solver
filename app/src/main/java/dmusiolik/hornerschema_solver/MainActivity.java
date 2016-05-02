package dmusiolik.hornerschema_solver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
        double gen = 0;

        if (runden.isChecked()) {
            gen = 1;
        }else{

            gen = 0.1;
        }


        for (int i = 0; startrange <= stoprange; startrange = startrange + Math.round(gen * 100) / 100.0) {

            startrange = Math.round(startrange * 100) / 100.0;
            ausgabe.setText(ausgabe.getText() + "Range: " + startrange + " ");
            x3 = Math.round(x3 * 100) /100.0;
            ausgabe.setText(ausgabe.getText() + " " + x3 + " ");

            ergebnis0 = 0;
            ergebnis0 = (startrange * x3) + x2;
            ergebnis0 = Math.round(ergebnis0 * 100) / 100.0;

            ausgabe.setText(ausgabe.getText() + " " + ergebnis0 + " ");

            ergebnis1 = 0;
            ergebnis1 = (startrange * ergebnis0) + x;
            ergebnis1 = Math.round(ergebnis1 * 100) / 100.0;

            ausgabe.setText(ausgabe.getText() + " " + ergebnis1 + " ");

            ergebnis0 = 0;
            ergebnis0 = (startrange * ergebnis1) + dez;
            ergebnis0 = Math.round(ergebnis0 * 100) / 100.0;

            ausgabe.setText(ausgabe.getText() + " " + ergebnis0 + " \n");

            if (runden.isChecked()) {
                ergebnis1 = 0;
                ergebnis1 = Math.round(ergebnis0);
                if (ergebnis1 == 0) {
                    nullstellen = nullstellen + "\nNullstelle gefunden!\nRange: " + startrange + "\n\n";
                }
            }else {
                System.out.println(ergebnis0 + " Progress working");
                if (ergebnis0 == 0.0) {
                    nullstellen = nullstellen + "\nNullstelle gefunden!\nRange: " + startrange + "\n\n";
                }
            }

        }
        if (nullstellen == "") {
            nullstellen = "\n\nCan't find Zeros with this range.\n\n";
        }
        ausgabe.setText(ausgabe.getText() + " " + nullstellen + "\n");
    }
}
