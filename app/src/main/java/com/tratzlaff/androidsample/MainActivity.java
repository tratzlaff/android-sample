package com.tratzlaff.androidsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity
{
    // For the next activity to query the extra data, you should define the key for your intent's extra using a public constant.
    // It's generally a good practice to define keys for intent extras using your app's package name as a prefix.
    // This ensures the keys are unique, in case your app interacts with other apps.
    public final static String EXTRA_MESSAGE = "com.tratzlaff.myfirstapp.MESSAGE";

    /**
     * The system creates every new instance of Activity by calling its onCreate() method.
     * This method performs basic application startup logic that should happen only once
     * for the entire life of the activity.
     *
     * Once the onCreate() finishes execution, the system calls the onStart() and onResume() methods in quick succession.
     * Your activity never resides in the Created or Started states. Technically, the activity becomes visible to the
     * user when onStart() is called, but onResume() quickly follows and the activity remains in the Resumed state until
     * something occurs to change that, such as when a phone call is received, the user navigates to another activity,
     * or the device screen turns off.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/starting.html#Create
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // Always call the superclass method first

        // Set the user interface layout for this Activity
        // The layout file is defined in the project res/layout/activity_main.xml file
        setContentView(R.layout.activity_main);
    }

    /**
     * Stop ongoing actions that should not continue while paused (such as a video)
     * or persist any information that should be permanently
     * saved in case the user continues to leave your app.
     *
     * When your activity receives a call to onPause(), it may be an indication that the
     * activity will be paused for a moment and the user may return focus to your activity.
     * However, it's usually the first indication that the user is leaving your activity.
     *
     * Avoid performing CPU-intensive work during onPause(), such as writing to a database,
     * because it can slow the visible transition to the next activity.
     * You should instead perform heavy-load shutdown operations during onStop().
     *
     * When your activity is paused, the Activity instance is kept resident in memory and is
     * recalled when the activity resumes. You don’t need to re-initialize components that
     * were created during any of the callback methods leading up to the Resumed state.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/pausing.html#Pause
     */
    @Override
    protected void onPause()
    {
        super.onPause(); // Always call the superclass method first
    }

    /**
     * The system calls this method every time your activity comes into the foreground,
     * including when it's created for the first time or when the user resumes your activity from the Paused state.
     * As such, you should implement onResume() to initialize components that you release during onPause()
     * and perform any other initializations that must occur each time the activity enters the Resumed state
     * (such as begin animations and initialize components only used while the activity has user focus).
     *
     * https://developer.android.com/training/basics/activity-lifecycle/pausing.html#Resume
     */
    @Override
    protected void onResume()
    {
        super.onResume(); // Always call the superclass method first
    }

    /**
     * Most apps don't need to implement this method because local class references are destroyed with
     * the activity and your activity should perform most cleanup during onPause() and onStop().
     * However, if your activity includes background threads that you created during onCreate() or
     * other long-running resources that could potentially leak memory if not properly closed,
     * you should kill them during onDestroy().
     *
     * The system calls onDestroy() after it has already called onPause() and onStop() in all situations except one:
     * when you call finish() from within the onCreate() method.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/starting.html#Destroy
     */
    @Override
    public void onDestroy()
    {
        super.onDestroy();  // Always call the superclass method first
    }


    // https://developer.android.com/training/basics/actionbar/adding-buttons.html#AddActions
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // When the user presses one of the action buttons or another item in the action overflow,
    // the system calls your activity's onOptionsItemSelected() callback method.
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }
        else if (id == R.id.action_search)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user clicks the Send button.
     *
     * See layout/activity_main.xml
     * In order for the system to match this method to the method name given to android:onClick, this method must:
     *  - Be public
     *  - Have a void return value
     *  - Have a View as the only parameter (this will be the View that was clicked)
     */
    public void sendMessage(View view)
    {
        // https://developer.android.com/guide/components/intents-filters.html
        // Create an Intent to start an activity called DisplayMessageActivity.
        // A Context is the first parameter (this is used because the Activity class is a subclass of Context)
        // The Class of the app component to which the system should deliver the Intent (in this case, the activity that should be started) is the second parameter.
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        // An Intent can carry data types as key-value pairs called extras.
        // The putExtra() method takes the key name in the first parameter and the value in the second parameter.
        intent.putExtra(EXTRA_MESSAGE, message);

        // To finish the intent, call the startActivity() method, passing it the Intent
        // The system receives this call and starts an instance of the Activity specified by the Intent.
        startActivity(intent);
    }
}
