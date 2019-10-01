package com.hp.kotlinstudio.utils

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

fun letsToastShort(mCtx: Context, mMessage : String){
    Toast.makeText(mCtx,mMessage, Toast.LENGTH_SHORT).show()
}

fun letsToastLong(mCtx: Context, mMessage : String){
    Toast.makeText(mCtx,mMessage, Toast.LENGTH_LONG).show()
}

@JvmOverloads
fun RecyclerView.affectOnItemClicks(onClick: ((position: Int, view: View) -> Unit)? = null, onLongClick: ((position: Int, view: View) -> Unit)? = null) {
    this.addOnChildAttachStateChangeListener(RecyclerItemClickListener(this, onClick, onLongClick))
}