package com.cookandroid.teamproject1.plan.view.fragment
import android.os.Bundle
import android.util.Log
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cookandroid.teamproject1.R
import com.cookandroid.teamproject1.databinding.FragmentPlanWriteBinding
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import com.google.android.material.datepicker.MaterialDatePicker



/**
 * 계획작성 프래그먼트
 */
class PlanWriteFragment : Fragment(){
    private var mBinding: FragmentPlanWriteBinding?=null
    private var inputText = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlanWriteBinding.inflate(inflater, container, false)
        mBinding = binding
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mBinding?.signUpingBackImg?.setOnClickListener(){
            it.findNavController().navigate(R.id.action_planWriteFragment_to_homeFragment)
        }


        mBinding?.fragmentPlanWriteCalendarImg?.setOnClickListener {


            val cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)+1
            val day = cal.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireActivity(), DatePickerDialog.OnDateSetListener { view, myear, mmonth, mdayOfMonth ->
                mBinding?.fragmentPlanWriteDateEt?.setText(""+ mdayOfMonth +"/"+ mmonth+ "/"+ myear)
            }, year, month, day)
            datePickerDialog.show()
        }


    }
}