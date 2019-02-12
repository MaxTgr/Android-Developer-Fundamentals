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
