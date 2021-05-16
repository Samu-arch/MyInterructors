package it.uninsubria.myinterructors

import android.annotation.SuppressLint
import android.content.*
import android.graphics.*
import android.graphics.Paint.FAKE_BOLD_TEXT_FLAG
import android.os.Build
import android.util.*
import android.view.*
import androidx.annotation.RequiresApi

class Interructors : View {

    private enum class STATE{ON, OFF}

    private var State = STATE.ON

    private var CANVAS = Canvas()

    private val PAINT = Paint()

    private val PATH_DARK_RED = Path()

    private val PATH_RED = Path()

    private val PATH_DARK_GREEN = Path()

    private val PATH_GREEN = Path()

    private val PATH_SIMBOL = Path()



    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }
    private fun init() {
        setOnClickListener{
            if(State == STATE.OFF) {
                State = STATE.ON
            } else {
                State = STATE.OFF
            }
            invalidate()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        CANVAS = canvas!!
        if(State == STATE.OFF) {
            DisegnaOFF()
        } else {
            DisegnaON()
        }
    }


    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun DisegnaOFF() {
        PAINT.setColor(context.getColor(R.color.Placca))
        PAINT.setShadowLayer(10f, 10f, 10f, R.color.black)
        CANVAS.drawRoundRect(20f, 20f, 290f, 420f, 35f, 35f, PAINT)

        PAINT.setColor(context.getColor(R.color.DarkRed))
        PATH_DARK_RED.moveTo(60f, 60f)
        PATH_DARK_RED.lineTo(250f, 60f)
        PATH_DARK_RED.lineTo(250f, 270f)
        PATH_DARK_RED.lineTo(275f, 360f)
        PATH_DARK_RED.lineTo(250f, 380f)
        PATH_DARK_RED.lineTo(60f, 380f)
        PATH_DARK_RED.lineTo(60f, 60f)
        PATH_DARK_RED.close()
        CANVAS.drawPath(PATH_DARK_RED, PAINT)

        PAINT.setShadowLayer(0f, 0f, 0f, R.color.black)
        PAINT.setColor(context.getColor(R.color.Red))
        PATH_RED.moveTo(65f, 65f)
        PATH_RED.lineTo(245f, 65f)
        PATH_RED.lineTo(245f, 270f)
        PATH_RED.lineTo(275f, 360f)
        PATH_RED.lineTo(85f, 360f)
        PATH_RED.lineTo(65f, 270f)
        PATH_RED.lineTo(65f, 65f)
        PATH_RED.close()
        CANVAS.drawPath(PATH_RED, PAINT)

        PAINT.setColor(context.getColor(R.color.black))
        CANVAS.drawLine(65f, 270f, 85f, 360f, PAINT)
        CANVAS.drawLine(85f, 360f, 60f, 380f, PAINT)
        CANVAS.drawLine(85f, 360f, 275f, 360f, PAINT)
        CANVAS.drawLine(275f, 360f, 250f, 380f, PAINT)

        PAINT.setColor(context.getColor(R.color.Simbol))
        CANVAS.drawOval(125f, 65f, 185f, 152f, PAINT)
        PATH_SIMBOL.moveTo(174f, 360f)
        PATH_SIMBOL.lineTo(186f, 360f)
        PATH_SIMBOL.lineTo(161f, 283f)
        PATH_SIMBOL.lineTo(149f, 283f)
        PATH_SIMBOL.lineTo(174f, 360f)
        PATH_SIMBOL.close()
        CANVAS.drawPath(PATH_SIMBOL, PAINT)
        PAINT.setColor(context.getColor(R.color.Red))
        CANVAS.drawOval(134f, 74f, 176f, 143f, PAINT)

        PAINT.setColor(context.getColor(R.color.black))
        PAINT.setTextSize(100f)

        CANVAS.drawText( "OFF", 60f, 500f, PAINT)
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    private fun DisegnaON() {
        PAINT.setColor(context.getColor(R.color.Placca))
        PAINT.setShadowLayer(10f, 10f, 10f, R.color.black)
        CANVAS.drawRoundRect(20f, 20f, 290f, 420f, 35f, 35f, PAINT)

        PAINT.setColor(context.getColor(R.color.DarkGreen))
        PATH_DARK_GREEN.moveTo(60f, 380f)
        PATH_DARK_GREEN.lineTo(250f, 380f)
        PATH_DARK_GREEN.lineTo(250f, 170f)
        PATH_DARK_GREEN.lineTo(275f, 80f)
        PATH_DARK_GREEN.lineTo(250f, 60f)
        PATH_DARK_GREEN.lineTo(60f,60f)
        PATH_DARK_GREEN.lineTo(60f, 380f)
        PATH_DARK_GREEN.close()
        CANVAS.drawPath(PATH_DARK_GREEN, PAINT)

        PAINT.setShadowLayer(0f, 0f, 0f, R.color.black)
        PAINT.setColor(context.getColor(R.color.Green))
        PATH_GREEN.moveTo(65f, 375f)
        PATH_GREEN.lineTo(245f, 375f)
        PATH_GREEN.lineTo(245f, 170f)
        PATH_GREEN.lineTo(275f, 80f)
        PATH_GREEN.lineTo(85f, 80f)
        PATH_GREEN.lineTo(65f, 170f)
        PATH_GREEN.lineTo(65f, 375f)
        PATH_GREEN.close()
        CANVAS.drawPath(PATH_GREEN, PAINT)

        PAINT.setColor(context.getColor(R.color.black))
        CANVAS.drawLine(65f, 170f, 85f, 80f, PAINT)
        CANVAS.drawLine(60f, 60f, 85f, 80f, PAINT)
        CANVAS.drawLine(85f, 80f, 275f, 80f, PAINT)
        CANVAS.drawLine(250f,60f, 275f, 80f, PAINT)
        

        PAINT.setColor(context.getColor(R.color.Simbol))
        CANVAS.drawOval(145f, 85f, 205f, 172f, PAINT)
        CANVAS.drawRect(164f, 298f, 176f, 375f, PAINT)
        PAINT.setColor(context.getColor(R.color.Green))
        CANVAS.drawOval(154f, 93f, 196f, 163f, PAINT)

        PAINT.setColor(context.getColor(R.color.black))
        PAINT.setTextSize(100f)

        CANVAS.drawText( "ON", 60f, 500f, PAINT)
    }
}