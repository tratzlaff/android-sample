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
     * When your activity is recreated after it was previously destroyed, you can recover your saved state from
     * the Bundle that the system passes your activity. Both the onCreate() and onRestoreInstanceState() callback
     * methods receive the same Bundle that contains the instance state information.
     *
     * Because the onCreate() method is called whether the system is creating a new instance of your activity or
     * recreating a previous one, you must check whether the state Bundle is null before you attempt to read it.
     * If it is null, then the system is creating a new instance of the activity, instead of restoring a previous
     * one that was destroyed.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/recreating.html#RestoreState
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
     * When your activity is recreated after it was previously destroyed, you can recover your saved state from
     * the Bundle that the system passes your activity. Both the onCreate() and onRestoreInstanceState() callback
     * methods receive the same Bundle that contains the instance state information.
     *
     * Instead of restoring the state during onCreate() you may choose to implement onRestoreInstanceState(),
     * which the system calls after the onStart() method. The system calls onRestoreInstanceState() only if
     * there is a saved state to restore, so you do not need to check whether the Bundle is null.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/recreating.html#RestoreState
     *
     * Also, see https://developer.android.com/guide/topics/resources/runtime-changes.html
     *
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState); // Always call the superclass so it can restore the view hierarchy
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
     * When your activity receives a call to the onStop() method, it's no longer visible
     * and should release almost all resources that aren't needed while the user is not using it.
     * Once your activity is stopped, the system might destroy the instance if it needs to recover system memory.
     * In extreme cases, the system might simply kill your app process without calling the activity's final
     * onDestroy() callback, so it's important you use onStop() to release resources that might leak memory.
     *
     * Although the onPause() method is called before onStop(), you should use onStop() to perform larger,
     * more CPU intensive shut-down operations, such as writing information to a database.
     *
     * When your activity is stopped, the Activity object is kept resident in memory and is recalled when
     * the activity resumes. You don’t need to re-initialize components that were created during any of the
     * callback methods leading up to the Resumed state. The system also keeps track of the current state
     * for each View in the layout, so if the user entered text into an EditText widget, that content is
     * retained so you don't need to save and restore it.
     *
     * Even if the system destroys your activity while it's stopped, it still retains the state of the View
     * objects (such as text in an EditText) in a Bundle (a blob of key-value pairs) and restores them if
     * the user navigates back to the same instance of the activity
     *
     * https://developer.android.com/training/basics/activity-lifecycle/stopping.html#Stop
     */
    @Override
    protected void onStop()
    {
        super.onStop(); // Always call the superclass method first
    }

    /**
     * When your activity comes back to the foreground from the stopped state, it receives a call to onRestart().
     * The system also calls the onStart() method, which happens every time your activity becomes visible
     * (whether being restarted or created for the first time). The onRestart() method, however, is called
     * only when the activity resumes from the stopped state, so you can use it to perform special restoration
     * work that might be necessary only if the activity was previously stopped, but not destroyed.
     *
     * It's uncommon that an app needs to use onRestart() to restore the activity's state, so there aren't any
     * guidelines for this method that apply to the general population of apps. However, because your onStop()
     * method should essentially clean up all your activity's resources, you'll need to re-instantiate them when
     * the activity restarts. Yet, you also need to instantiate them when your activity is created for the first
     * time (when there's no existing instance of the activity). For this reason, you should usually use the onStart()
     * callback method as the counterpart to the onStop() method, because the system calls onStart() both when it
     * creates your activity and when it restarts the activity from the stopped state.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/stopping.html#Start
     */
    @Override
    protected void onRestart()
    {
        super.onRestart(); // Always call the superclass method first
    }

    /**
     * This method is called every time this activity becomes visible
     * (whether being restarted or created for the first time).
     *
     * Your onStop() method should essentially clean up all your activity's resources, so you'll need to re-instantiate
     * them when the activity restarts. You also need to instantiate them when your activity is created for the first
     * time (when there's no existing instance of the activity). For this reason, you should usually use the onStart()
     * callback method as the counterpart to the onStop() method, because the system calls onStart() both when it
     * creates your activity and when it restarts the activity from the stopped state.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/stopping.html#Start
     */
    @Override
    protected void onStart()
    {
        super.onStart(); // Always call the superclass method first
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
     *
     * There are a few scenarios in which your activity is destroyed due to normal app behavior,
     * such as when the user presses the Back button or your activity signals its own destruction by calling finish().
     * The system may also destroy your activity if it's currently stopped and hasn't been used in a long time or the
     * foreground activity requires more resources so the system must shut down background processes to recover memory.
     *
     * When your activity is destroyed because the user presses Back or the activity finishes itself,
     * the system's concept of that Activity instance is gone forever because the behavior indicates the
     * activity is no longer needed. However, if the system destroys the activity due to system constraints
     * (rather than normal app behavior), then although the actual Activity instance is gone, the system
     * remembers that it existed such that if the user navigates back to it, the system creates a new instance
     * of the activity using a set of saved data that describes the state of the activity when it was destroyed.
     * The saved data that the system uses to restore the previous state is called the "instance state" and is a
     * collection of key-value pairs stored in a Bundle object.
     *
     * Caution: Your activity will be destroyed and recreated each time the user rotates the screen.
     * When the screen changes orientation, the system destroys and recreates the foreground activity because the
     * screen configuration has changed and your activity might need to load alternative resources (such as the layout).
     *
     * By default, the system uses the Bundle instance state to save information about each View
     * object in your activity layout (such as the text value entered into an EditText object).
     * So, if your activity instance is destroyed and recreated, the state of the layout is restored
     * to its previous state with no code required by you. However, your activity might have more state information
     * that you'd like to restore, such as member variables that track the user's progress in the activity.
     *
     * Note: In order for the Android system to restore the state of the views in your activity,
     * each view must have a unique ID, supplied by the android:id attribute.
     *
     * To save additional data about the activity state, you must override the onSaveInstanceState() callback method.
     * The system calls this method when the user is leaving your activity and passes it the Bundle object that will
     * be saved in the event that your activity is destroyed unexpectedly. If the system must recreate the activity
     * instance later, it passes the same Bundle object to both the onRestoreInstanceState() and onCreate() methods.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/recreating.html
     */
    @Override
    public void onDestroy()
    {
        super.onDestroy();  // Always call the superclass method first
    }

    /**
     * As your activity begins to stop, the system calls onSaveInstanceState() so your activity can save state
     * information with a collection of key-value pairs. The default implementation of this method saves information
     * about the state of the activity's view hierarchy, such as the text in an EditText widget or the scroll position
     * of a ListView.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/recreating.html#SaveState
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        // To save additional state information for your activity, you must add key-value pairs to the Bundle object.

        super.onSaveInstanceState(outState); // Always call the superclass so it can save the view hierarchy state
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
