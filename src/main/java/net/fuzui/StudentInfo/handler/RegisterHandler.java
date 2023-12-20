package net.fuzui.StudentInfo.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.fuzui.StudentInfo.pojo.Student;
import net.fuzui.StudentInfo.pojo.Teacher;
import net.fuzui.StudentInfo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: StudentInfo
 * @Package: net.fuzui.StudentInfo.handler
 * @ClassName: RegisterHandler
 * @Description: admin的handler层（servlet）
 * @Author: admin
 * @CreateDate: 2019-04-10 22:50
 * @UpdateUser: admin
 * @UpdateDate: 2019-04-10 22:50
 * @UpdateRemark: 新建
 * @Version: 1.0
 */

@Controller
@RequestMapping("/RegisterHandler")
public class RegisterHandler {
    @Autowired
	AdminService adminService;
    @Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;

	/**
	 * JavaScript学的不好，目前只能通过这种方式把三级联动下拉列表的val改变为以下值传给数据库。
	 * 
	 */
	String[] arr_belongcoll = {"计算机学院","建筑学院","外国语学院","人文学院"};
	String[][] arr_belongpro = {
                    {"网络工程","软件工程","物联网","信息管理"},
                    {"土木工程","测绘工程","工程造价", "城市规划"},
                    {"英语", "日语", "俄语", "西班牙语"},
                    {"汉语言", "历史", "新闻", "网络新媒体"}
				};
	String[][][] arr_belongcla = {
                {
                    {"网络B151","网络B152","网络B161","网络B162","网络B171","网络B172"},
                    {"软件B151","软件B152","软件B161","软件B162","软件B171","软件B172"},
                    {"物联B151","物联B152","物联B161","物联B162","物联B171","物联B172"},
                    {"信管B151","信管B152","信管B161","信管B162","信管B171","信管B172"}
                    
                },
                {
                    {"土木B151","土木B152","土木B161","土木B162","土木B171","土木B172"},
                    {"测绘B151","测绘B152","测绘B161","测绘B162","测绘B171","测绘B172"},
                    {"造价B151","造价B152","造价B161","造价B162","造价B171","造价B172"},
                    {"规划B151","规划B152","规划B161","规划B162","规划B171","规划B172"}
                    
                },
                {
                    {"英语B151","英语B152","英语B161","英语B162","英语B171","英语B172"},
                    {"日语B151","日语B152","日语B161","日语B162","日语B171","日语B172"},
                    {"俄语B151","俄语B152","俄语B161","俄语B162","俄语B171","俄语B172"},
                    {"牙语B151","牙语B152","牙语B161","牙语B162","牙语B171","牙语B172"}
                    
				},
                {
                    {"汉语B151","汉语B152","汉语B161","汉语B162","汉语B171","汉语B172"},
                    {"历史B151","历史B152","历史B161","历史B162","历史B171","历史B172"},
                    {"新闻B151","新闻B152","新闻B161","新闻B162","新闻B171","新闻B172"},
                    {"网媒B151","网媒B152","网媒B161","网媒B162","网媒B171","网媒B172"}
                    
				}
		};

 // 添加
 	@RequestMapping("/addStudent")
 	public String addStudent(Student student, Model model) {
 		int col = Integer.parseInt(student.getCollege());
 		int pro = Integer.parseInt(student.getProfession());
 		int cla = Integer.parseInt(student.getClassr());
 		//总感觉前端js写的有问题。
 		student.setCollege(arr_belongcoll[pro]);
 		student.setProfession(arr_belongpro[pro][col]);
 		student.setClassr(arr_belongcla[pro][col][cla]);

 		if (studentService.insertStudent(student) != 0) {
 			model.addAttribute("student", student);
 			return "success";
 			// return "admin/addStudent";
 		} else {
 			return "fail";
 		}

 	}
 	@RequestMapping("/addAdmin")
 	public String addAdmin(String tname, String tpassword, Model model) {
 		if (adminService.insert(tname, tpassword) != 0) {
 			return "success";
 		} else {
 			return "fail";
 		}

 	}

	@RequestMapping("/addTeacher")
	public String addTeacher(Teacher teacher, Model model, HttpSession httpSession) {

		if (teacherService.insertTeacher(teacher) != 0) {
			model.addAttribute("teacher", teacher);

			//---------------------------------待优化-----同样不能实时刷新--------------------------------------------
			return "success";
		} else {
			return "fail";
		}

	}

}
