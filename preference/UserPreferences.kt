package preference

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The user's preferences.
 */
@Singleton
class UserPreferences @Inject constructor(
    @UserPrefs preferences: SharedPreferences,
    screenSize: ScreenSize
) {

    /**
     * True if Web RTC is enabled in the browser, false otherwise.
     */
    var webRtcEnabled by preferences.booleanPreference(WEB_RTC, false)

    /**
     * The folder into which files will be downloaded.
     */
    var downloadDirectory by preferences.stringPreference(DOWNLOAD_DIRECTORY, FileUtils.DEFAULT_DOWNLOAD_PATH)

    /**
     * The index of the chosen search engine.
     *
     * @see SearchEngineProvider
     */
    var searchChoice by preferences.intPreference(SEARCH, 1)

    /**
     * The index of the rendering mode that should be used by the browser.
     */
    var renderingMode by preferences.enumPreference(RENDERING_MODE, RenderingMode.NORMAL)

    /**
     * The local file from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    var hostsLocalFile by preferences.nullableStringPreference(HOSTS_LOCAL_FILE)

    /**
     * The remote URL from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    var hostsRemoteFile by preferences.nullableStringPreference(HOSTS_REMOTE_FILE)

}
