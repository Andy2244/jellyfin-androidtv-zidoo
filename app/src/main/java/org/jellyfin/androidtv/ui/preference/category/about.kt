package org.jellyfin.androidtv.ui.preference.category

import android.os.Build
import org.jellyfin.androidtv.BuildConfig
import org.jellyfin.androidtv.R
import org.jellyfin.androidtv.ui.preference.dsl.OptionsScreen
import org.jellyfin.androidtv.ui.preference.dsl.link
import org.jellyfin.androidtv.ui.preference.screen.LicensesScreen
import org.jellyfin.androidtv.util.DeviceUtils

fun OptionsScreen.aboutCategory() = category {
	setTitle(R.string.pref_about_title)

	link {
		// Hardcoded strings for troubleshooting purposes
		title = "Jellyfin app version"
		content = "jellyfin-androidtv ${BuildConfig.VERSION_NAME} ${BuildConfig.BUILD_TYPE}"
		icon = R.drawable.ic_jellyfin
	}

	link {
		setTitle(R.string.pref_device_model)
		content = "${Build.BRAND} ${Build.MODEL}/${Build.MANUFACTURER} , Android: ${Build.VERSION.RELEASE}, API: ${Build.VERSION.SDK_INT}"
		icon = R.drawable.ic_tv
	}

	link {
		setTitle(R.string.pref_device_fw)
		content = "${DeviceUtils.getSystemPropertyCached("ro.product.version")}\n" +
				"New Zidoo API: ${DeviceUtils.hasNewZidooApi()}"
		icon = R.drawable.ic_tv
	}

	link {
		setTitle(R.string.licenses_link)
		setContent(R.string.licenses_link_description)
		icon = R.drawable.ic_guide
		withFragment<LicensesScreen>()
	}
}
