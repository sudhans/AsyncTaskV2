# AsyncTaskV2
Migrate existing AsyncTask classes for Android 11 or above

AsyncTasks is deprecated from Android 11. Google has recommended to use Executors and Handlers to 
achieve the background computation and UI updates.
For larger projects (with more AsyncTasks), replacing the Asynctask with Executors/Handlers, 
could be a challenge - i.e More code changes, more testing and more risk.

This project aims to minimize the migration effort. 
The AsyncTaskV2 class presented here has a similar API but internally it uses executors and 
handlers. For migration, instead of extending AsyncTask, extend AsyncTaskV2.

Use the sampleapp for reference.

Differences:
AsyncTask2 is not strict like the actual AsyncTask in throwing 
exceptions if the execute() method is called after the asynctask is complete.

Improvements:
Implement a ThreadFactory, if you would like to give the custom 
thread names for the executor.
