package vn.edu.hust.studentman

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class AddStudentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText: EditText = view.findViewById(R.id.edit_text_name)
        val idEditText: EditText = view.findViewById(R.id.edit_text_id)
        val saveButton: Button = view.findViewById(R.id.btn_save)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty()) {
                (activity as MainActivity).addStudent(StudentModel(name, id))
                findNavController().popBackStack()
            }
        }
    }
}
