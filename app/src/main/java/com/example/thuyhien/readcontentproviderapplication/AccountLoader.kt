package com.example.thuyhien.readcontentproviderapplication

import android.content.Context
import android.database.Cursor
import com.example.thuyhien.readcontentproviderapplication.contentProvider.AccountEntry
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by thuyhien on 4/24/18.
 */
class AccountLoader {
    companion object {
        fun loadAccount(context: Context?) {
            doAsync {
                val projectionFields = arrayOf(AccountEntry.USER_COL,
                        AccountEntry.PASSWORD_COL)
                val cursor = context?.contentResolver?.query(AccountEntry.ACCOUNT_CONTENT_URI,
                        projectionFields, null, null, null)
                val account = getAccount(cursor)
                cursor?.close()
                uiThread {
                    (context as AccountCallBackListener).onLoadAccountSuccess(account)
                }
            }
        }

        private fun getAccount(cursor: Cursor?): Account? {
            cursor?.let {
                val userIdx = cursor.getColumnIndexOrThrow(AccountEntry.USER_COL)
                val passIdx = cursor.getColumnIndexOrThrow(AccountEntry.PASSWORD_COL)
                if (cursor.moveToNext()) {
                    val account = Account(cursor.getString(userIdx), cursor.getString(passIdx))
                    return account
                }
            }
            return null
        }
    }
}