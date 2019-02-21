# Log tag naming

You should use a simpleName as log tag; example:

`String LOG_TAG = MainActivity.class.getSimpleName();`

`String LOG_TAG = NumbersActivity.class.getSimpleName();`

To use as: `Log.e(LOG_TAG, "Error!");`
