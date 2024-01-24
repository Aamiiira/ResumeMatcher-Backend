package com.ResumeMatcher.space.services;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Component;
@Component
public class PythonService {
  /*  public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("C:\\Users\\hp\\Desktop\\test\\PFE-Project\\Resume.Scanner-master\\python.py");
        PyFunction pyFunction = (PyFunction) interpreter.get("get_resume_job_match_percentage", PyFunction.class);
        PyObject result = pyFunction.__call__(new PyString("argument1"), new PyString("argument2"));
        System.out.println(result.toString());
    }*/

/*	public void runScript() {
		PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("C:\\Users\\hp\\Desktop\\candidats\\python.py");
        PyFunction pyFunction = (PyFunction) interpreter.get("get_resume_job_match_percentage", PyFunction.class);
        PyObject result = pyFunction.__call__(new PyString("resume_text"), new PyString("job_description_text"));
        System.out.println(result.toString());
		
	}*/
}
