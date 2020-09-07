package oop_06.black_jeck;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2015-11-01.
 */
public class AppView {

    private Activity act;

    public AppView(Activity act) {
        this.act = act;
    }

    public Activity getAct(){
        return this.act ;
    }
    public void printString(String str) {

        TextView text = (TextView) act.findViewById(R.id.print);
        String oldStr = text.getText().toString();
        String newStr = oldStr + "\n" + str;
        text.setText(newStr);
    }

    public synchronized String scanString() {
        String str ;

        act.findViewById(R.id.scanBt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notify() ;
            }
        });
        try{wait() ;}catch(Exception e){}

        EditText edit = (EditText)act.findViewById(R.id.editText) ;
        str = edit.getText().toString() ;
        edit.setText("") ;
        MainActivity.scan = 0 ;
        return str ;

    }


}
