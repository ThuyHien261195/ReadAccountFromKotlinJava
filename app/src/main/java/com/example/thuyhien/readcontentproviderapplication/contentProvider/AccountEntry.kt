package com.example.thuyhien.readcontentproviderapplication.contentProvider

import android.provider.BaseColumns

/**
 * Created by thuyhien on 4/24/18.
 */
class AccountEntry : BaseColumns {
    companion object {
        val ACCOUNT_CONTENT_URI = AccountContract.BASE_CONTENT_URI.buildUpon().appendPath(AccountContract.PATH_ACCOUNT).build()


        const val ACCOUNT_TABLE_NAME = "account"
        const val ID = "Id"
        const val USER_COL = "User"
        const val PASSWORD_COL = "Password"

    }
}