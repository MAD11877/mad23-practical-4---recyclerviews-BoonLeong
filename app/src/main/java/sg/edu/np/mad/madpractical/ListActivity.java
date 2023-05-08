package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //External Variables
        ImageView userImage = (ImageView) findViewById(R.id.listUserImage);

        Intent MainActivity = new Intent(ListActivity.this, MainActivity.class);

        Random random = new Random();

        //Initialization
        AlertDialog.Builder testProfileInfo = new AlertDialog.Builder(this);
        testProfileInfo.setTitle("Profile");
        testProfileInfo.setMessage("MADness");
        testProfileInfo.setCancelable(true);
        testProfileInfo.setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                int randInt = random.nextInt();

                MainActivity.putExtra("randInt", randInt);
                startActivity(MainActivity);
            }
        });
        testProfileInfo.setNegativeButton("CLOSE", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dialog.dismiss();
            }
        });

        //Event Triggers
        userImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog testProfilePopUp = testProfileInfo.create();
                testProfilePopUp.show();
            }
        });
    }
}