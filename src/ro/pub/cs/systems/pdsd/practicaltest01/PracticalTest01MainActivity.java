package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private class ButtonClickListener implements Button.OnClickListener {
	       
        @Override
        public void onClick(View view) {
      	  CheckBox cb1 = (CheckBox)PracticalTest01MainActivity.this.findViewById(R.id.checkBox1);
      	  CheckBox cb2 = (CheckBox)PracticalTest01MainActivity.this.findViewById(R.id.checkBox2);
      	  EditText et1 = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.editText1);
          EditText et2 = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.editText2);
     
          switch(view.getId()) {
            case R.id.checkBox1:
          	  if(cb1.isChecked())
          		  et1.setEnabled(true);
          	  else
          		  et1.setEnabled(false);
              break;
            case R.id.checkBox2:
          	  if(cb2.isChecked())
          		  et2.setEnabled(true);
          	  else
          		  et2.setEnabled(false);
              break;
            case R.id.gotoBtn:
                Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
                intent.putExtra("edit1", String.valueOf(et1.getText()));
                intent.putExtra("edit2", String.valueOf(et2.getText()));
                startActivityForResult(intent, 1);
                break;
          }
        }
      } 
      
      
      

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        
        CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        EditText ed1 = (EditText)findViewById(R.id.editText1);
        EditText ed2 = (EditText)findViewById(R.id.editText2);
        Button gotoActBtn = (Button)findViewById(R.id.gotoBtn);
        
        cb1.setOnClickListener(buttonClickListener);
        cb2.setOnClickListener(buttonClickListener);
        gotoActBtn.setOnClickListener(buttonClickListener);
        

        if(savedInstanceState == null) {
        	ed1.setEnabled(false);
        	ed2.setEnabled(false);
        }
     
    }
    
    @Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        EditText et1 = (EditText)findViewById(R.id.editText1);
        EditText et2 = (EditText)findViewById(R.id.editText2);
		
		savedInstanceState.putString("EDIT1", et1.getText().toString());
		savedInstanceState.putString("EDIT2", et2.getText().toString());
		savedInstanceState.putBoolean("CHECK1", cb1.isChecked());
		savedInstanceState.putBoolean("CHECK2", cb2.isChecked());
		
	}
	
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		CheckBox cb1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        EditText et1 = (EditText)findViewById(R.id.editText1);
        EditText et2 = (EditText)findViewById(R.id.editText2);
		
		
		et1.setText(savedInstanceState.getString("EDIT1"));
		et2.setText(savedInstanceState.getString("EDIT2"));
		cb1.setChecked(savedInstanceState.getBoolean("CHECK1"));
		cb2.setChecked(savedInstanceState.getBoolean("CHECK2"));
	}
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The 2nd activity returned with " + resultCode, Toast.LENGTH_LONG).show();
	  }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
