package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_submit).setOnClickListener(){
            calculateLoan();
        }
    }

    private fun calculateLoan(){
        val carPrice:Double = inputCarPrice.text.toString().toDouble()
        val downPayment : Double = inputDownPayment.text.toString().toDouble()
        val loanPeriod : Double  = inputLoanPeriod.text.toString().toDouble()
        val interestRate : Double = inputInterestRate.text.toString().toDouble()

        var carLoan = String.format("%.2f", carPrice - downPayment)
        var interest = String.format("%.2f", carLoan.toDouble() * (interestRate * loanPeriod/100))
        var monthlyRepayment = String.format("%.2f", (carLoan.toDouble() + interest.toDouble())/ loanPeriod/12)

        val textCarLoan: TextView = findViewById(R.id.textview_carLoan)
        val textInterest: TextView = findViewById(R.id.textview_interest)
        val textMonthlyRepayment: TextView = findViewById(R.id.textview_monthlyRepayment)

        textCarLoan.text = "Loan: RM "+ carLoan
        textInterest.text = "Interest: RM "+ interest
        textMonthlyRepayment.text = "Monthly Repayment: RM "+ monthlyRepayment
    }
}
