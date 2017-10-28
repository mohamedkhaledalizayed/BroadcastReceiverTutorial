# BroadcastReceiverTutorial
Some Notes:

1-You can use Broadcast receivers to do small bits of work which must complete within 5 seconds. If they don’t, then an Application Not Responding dialog appears.
2-Do not forget to unregister a dynamically registered receiver by using Context.unregisterReceiver() method. If you forget this, the Android system reports a leaked broadcast receiver error. For instance, if you registered a receive in onResume() methods of your activity, you should unregister it in the onPause() method.

some link

part 1 https://www.101apps.co.za/articles/android-broadcast-receivers.html

part 2 https://www.101apps.co.za/articles/android-broadcast-receivers-a-tutorial.html

