# ExecutorAsyncTask
Migrate existing AsyncTask classes for Android 11 or above

AsyncTasks is deprecated from Android 11. Google has recommened to use Executors and Handlers to achieve the background computation and UI updates.
For larger projects (with more AsyncTasks), replacing the asynctask with Executors/Handlers, could be a challenge. More code changes, more testing and more risk.

This project aims to minimize the migration effort. The ExecutorAsyncTask class presented here has a similar API but internally it uses executors and handlers. For migration, instead of extending AsyncTask, extend ExecutorAsyncTask.

You will find sample usage inside the sample folder.
