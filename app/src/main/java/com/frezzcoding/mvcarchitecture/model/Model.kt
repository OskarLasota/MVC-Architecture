package com.frezzcoding.mvcarchitecture.model

import java.lang.IndexOutOfBoundsException
import java.util.*

class Model : Observable() {

    private var mList = arrayOf(0,0,0)


    fun getValueAtIndex(the_index : Int) : Int {
        try{

        }catch(e : ArrayIndexOutOfBoundsException){

        }
        return mList[the_index]
    }

    fun setValueAtIndex(the_index : Int) {
       try {
           mList[the_index] = mList[the_index] + 1
           setChanged()
           notifyObservers()
       }catch(e : ArrayIndexOutOfBoundsException){

       }
    }

}