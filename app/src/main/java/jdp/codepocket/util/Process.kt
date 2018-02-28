package jdp.codepocket.util

import android.os.AsyncTask
import android.os.Handler
import android.os.Looper
import android.support.v4.app.FragmentActivity

/**
* Created by jamesdeperio on 01/29/2018.
**/

object Process {
    inline fun runOnUIThread(activity: FragmentActivity, crossinline onRunning:() -> Unit) = activity.runOnUiThread { onRunning() }
    inline fun runOnUIThread(crossinline onRunning:() -> Unit) {
        Handler(Looper.getMainLooper()).post   { onRunning() }
    }
    inline fun runOnBackgroundThread(crossinline onRunning:() -> Unit,crossinline onCompleted:() -> Unit) = AsyncTask.execute {
        onRunning()
        onCompleted()
    }
    inline fun runOnBackgroundThread(crossinline onRunning:() -> Unit) = AsyncTask.execute { onRunning() }

    inline fun tryCatch(onTrying: () -> Unit,onError: (ex:Exception) -> Unit ,onCompleted: () -> Unit) = try { onTrying() }
    catch (e:Exception) { onError(e) }
    finally { onCompleted() }

    inline fun tryCatch(onTrying: () -> Unit,onError: (ex:Exception) -> Unit ) = try { onTrying() }
    catch (e:Exception) { onError(e) }

    inline fun tryCatch(onTrying: () -> Unit ) = try { onTrying() }
    catch (e:Exception) { e.printStackTrace() }

}
