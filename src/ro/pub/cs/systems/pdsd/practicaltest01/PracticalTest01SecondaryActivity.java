package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01SecondaryActivity extends Activity {

	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 
	  private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.button1:
	          setResult(RESULT_OK, new Intent());
	          finish();
	          break;
	        case R.id.button2:
	          setResult(RESULT_CANCELED, new Intent());
	          finish();
	          break;
	      }
	    }
	  }  
	 
	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_practical_test01_secondary);
	    
	    EditText et1 = (EditText)findViewById(R.id.editText1_2);
        EditText et2 = (EditText)findViewById(R.id.editText2_2);
	 
	    Intent intent = getIntent();
	    if (intent != null) {
	      String editText1 = intent.getStringExtra("edit1");
	      String editText2 = intent.getStringExtra("edit2");
	      if (editText1 != null) {
	    	  et1.setText(editText1);
	      }
	      if (editText2 != null) {
	    	  et2.setText(editText2);
	      }
	    }
	 
	    Button buttonOk = (Button)findViewById(R.id.button1);
	    buttonOk.setOnClickListener(buttonClickListener);
	    Button buttonCancel = (Button)findViewById(R.id.button2);
	    buttonCancel.setOnClickListener(buttonClickListener);      
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
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
