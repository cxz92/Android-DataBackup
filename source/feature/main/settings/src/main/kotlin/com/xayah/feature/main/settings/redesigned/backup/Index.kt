package com.xayah.feature.main.settings.redesigned.backup

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.xayah.core.datastore.KeyBackupItself
import com.xayah.core.datastore.KeyCheckKeystore
import com.xayah.core.datastore.KeyCompatibleMode
import com.xayah.core.datastore.KeyCompressionTest
import com.xayah.core.datastore.KeyFollowSymlinks
import com.xayah.core.ui.component.Switchable
import com.xayah.core.ui.model.StringResourceToken
import com.xayah.core.ui.token.SizeTokens
import com.xayah.core.ui.util.fromString
import com.xayah.core.ui.util.fromStringId
import com.xayah.feature.main.settings.R
import com.xayah.feature.main.settings.redesigned.SettingsScaffold

@ExperimentalLayoutApi
@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun PageBackupSettings() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    SettingsScaffold(
        scrollBehavior = scrollBehavior,
        title = StringResourceToken.fromString("Backup settings"),
        actions = {}
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(SizeTokens.Level24)
        ) {
            Column {
                Switchable(
                    key = KeyCheckKeystore,
                    title = StringResourceToken.fromStringId(R.string.check_keystore),
                    checkedText = StringResourceToken.fromStringId(R.string.check_keystore_desc),
                )
                Switchable(
                    key = KeyBackupItself,
                    title = StringResourceToken.fromStringId(R.string.backup_itself),
                    checkedText = StringResourceToken.fromStringId(R.string.backup_itself_desc),
                )
                Switchable(
                    key = KeyCompressionTest,
                    title = StringResourceToken.fromStringId(R.string.compression_test),
                    checkedText = StringResourceToken.fromStringId(R.string.compression_test_desc),
                )
                Switchable(
                    key = KeyCompatibleMode,
                    title = StringResourceToken.fromStringId(R.string.compatible_mode),
                    checkedText = StringResourceToken.fromStringId(R.string.compatible_mode_desc),
                )
                Switchable(
                    key = KeyFollowSymlinks,
                    title = StringResourceToken.fromStringId(R.string.follow_symlinks),
                    checkedText = StringResourceToken.fromStringId(R.string.follow_symlinks_desc),
                )
            }
        }
    }
}
