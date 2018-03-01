package jdp.codepocket.util

/**
* Created by jamesdeperio on 01/29/2018.
**/

object Process {
    inline fun tryCatch(onTrying: () -> Unit,onError: (ex:Exception) -> Unit ,onCompleted: () -> Unit) = try { onTrying() }
    catch (e:Exception) { onError(e) }
    finally { onCompleted() }

    inline fun tryCatch(onTrying: () -> Unit,onError: (ex:Exception) -> Unit ) = try { onTrying() }
    catch (e:Exception) { onError(e) }

    inline fun tryCatch(onTrying: () -> Unit ) = try { onTrying() }
    catch (e:Exception) { e.printStackTrace() }

    inline fun tryCatch(onTrying: () -> Unit ,onCompleted: () -> Unit ) = try { onTrying() }
    catch (e:Exception) { e.printStackTrace() }
    finally {  onCompleted() }

}
