# Activity inheritance

For the correct using of the "back" button a inheritance system should be used in the manifest:

```
<activity android:name=".SecondActivity"
            android:label = "@string/activity2_name"
            android:parentActivityName=".MainActivity">
            <meta-data 
                android:name="android.support.PARENT_ACTIVITY"
                android:value=
                    "me.maxcostadev.twoactivities.MainActivity" />
</activity>
```
`label => action bar name`

`parentActivityName => parent that the back button will send to`

`meta-data => will be used for api 16 or lower to do the same as above`

# Bundle keys

Bundles are objects that holds key value data, you should use a static final String for these keys; example:

`public static final String EXTRA_MESSAGE = "twoactivities.extra.MESSAGE";`

`public static final String EXTRA_MESSAGE = "twoactivities.extra.REPLY";`

And you can refer to them as:

`EXTRA_MESSAGE` from the original activity or `Activity.EXTRA_MESSAGE` from another activity

# Intent that wants a reply

You can call an activity with an intent for the only purpose of asking some response; example:

First you need an "id" for what you want as response: `public static final int TEXT_REQUEST = 1;`

Calling the activity with the intent and the required response: `startActivityForResult(intent, TEXT_REQUEST);`

Then in the other activity you return the data with: 
```
replyIntent.putExtra(EXTRA_REPLY, "requested text!");
setResult(RESULT_OK,replyIntent);
```
where RESULT_OK is a static value given from the Android Activity (native)

then in the main activity you override the function `onActivityResult`

inside you can handle the resulting data, for example:
```
@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                Log.d(LOG_TAG, reply);
            }
        }
}
```

#### Notes: EXTRA_REPLY is a bundle key as discursed in #Bundle keys
####        LOG_TAG is the name of the activity as discursed in #Log tag naming @01.1
