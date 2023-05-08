package sg.edu.np.mad.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //External Variables
        Button followButton = (Button) findViewById(R.id.btnFollow);
        Button msgButton = (Button) findViewById(R.id.btnMessage);
        TextView userName = (TextView) findViewById(R.id.userName);
        TextView userDesc = (TextView) findViewById(R.id.userDesc);

        Intent MessageGroup = new Intent(MainActivity.this, MessageGroup.class);
        Intent receivingEnd = getIntent();

        //Initialization
        String testUserInt = " " + receivingEnd.getIntExtra("randInt", 0);
        User testUser = new User( "MAD" + testUserInt,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                        "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
                0,
                false);
        String name = testUser.getName();
        String description = testUser.getDescription();

        userName.setText(name);
        userDesc.setText(description);
        if (testUser.isFollowed()) {
            followButton.setText(R.string.button_text_unfollow);
        }
        else {
            followButton.setText(R.string.button_text_follow);
        }

        //Event Triggers
        followButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                testUser.changeFollowStatus();
                if (testUser.isFollowed()) {
                    followButton.setText(R.string.button_text_unfollow);
                    Toast.makeText(getApplicationContext(), R.string.toast_followed, Toast.LENGTH_SHORT).show();
                }
                else {
                    followButton.setText(R.string.button_text_follow);
                    Toast.makeText(getApplicationContext(), R.string.toast_unfollowed, Toast.LENGTH_SHORT).show();
                }
            }
        });

        msgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(MessageGroup);
            }
        });
    }
}