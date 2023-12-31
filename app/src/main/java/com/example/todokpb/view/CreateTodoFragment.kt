package com.example.todokpb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.todokpb.R
import com.example.todokpb.databinding.FragmentCreateTodoBinding
import com.example.todokpb.model.Todo
import com.example.todokpb.util.NotificationHelper
import com.example.todokpb.util.TodoWorker
import com.example.todokpb.viewmodel.DetailTodoViewModel
import java.util.concurrent.TimeUnit

class CreateTodoFragment : Fragment(), TodoCreateLayoutInterface {
    private lateinit var viewModel: DetailTodoViewModel
    private lateinit var dataBinding: FragmentCreateTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_todo,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(DetailTodoViewModel::class.java)
        dataBinding.todo = Todo("","",3,0)
        dataBinding.buttonlistener = this
        dataBinding.radiolistener = this



//        val btnAdd = view.findViewById<Button>(R.id.btnAdd)
//        btnAdd.setOnClickListener {
//            val myWorkRequest = OneTimeWorkRequestBuilder<TodoWorker>().setInitialDelay(30, TimeUnit.SECONDS)
//                .setInputData(workDataOf(
//                        "title" to "Todo Created",
//                        "message" to "A new todo has been created! Stay focus!")).build()
//            WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
//
//
//            val radioGroupPriority = view.findViewById<RadioGroup>(R.id.radioGroupPriority)
//            var radio = view.findViewById<RadioButton>(radioGroupPriority.checkedRadioButtonId)
//
//            val txtTitle = view.findViewById<EditText>(R.id.txtTitle)
//            val txtNotes = view.findViewById<EditText>(R.id.txtNotes)
//            var todo = Todo(txtTitle.text.toString(), txtNotes.text.toString(), radio.tag.toString().toInt())
//            viewModel.addTodo(todo)
//            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
//            Navigation.findNavController(it).popBackStack()
//        }
    }

    override fun onRadioClick(v: View, priority: Int, obj: Todo) {

    }

    override fun onButtonAddClick(v: View) {
        var todo = Todo("L", "L", 3,0)
        viewModel.addTodo(todo)
        Toast.makeText(view?.context, "Data added", Toast.LENGTH_LONG).show()
    }
}