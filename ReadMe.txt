【使用】
1、在com.vlife.qa.casedesign.tc或com.vlife.qa.casedesign.performance中建测试类，继承UiAutomatorTestCase，如要输出报告（各用例测试时间，报错log和截图），继承TestCaseResult
2、测试类中，用例方法以test开头（junit标准），设备操作参考API文档
3、为方便java中调试，引入UiAutomatorUtil：main方法中new一个UiAutomatorUtil
其中：
jarName-要push到手机中的jar包名称
testClass-当前测试类名（包名.类名） 
testName-被测方法名（即测试用例名），可省，如省略默认执行类中所有方法
androidId-targetID



【简述】
com.vlife.qa.base
封装一些常用方法，与UiautomatorAPI无关，主要用java常用方法辅助测试结果对比，如：文件读字段赋值给变量（待完成，主要针对解锁坐标参数化）
图像对比、随机数，获取列表中子布局数量、正则匹配、获取系统信息等


com.vlife.qa.casedesign.performance
用于性能测试的用例


com.vlife.qa.casedesign.tc
功能用例
接口被实现后的用例放此处


com.vlife.qa.i
常用操作/测试用例步骤接口，不同厂商ROM控件类型不同，但步骤类似，这里整理出步骤，测试时具体写脚本获取控件，实现页面操作即可


com.vlife.qa.logcat
Log和dump系统信息


com.vlife.qa.ServerSocket
模拟server回包，mock


com.vlife.qa.tutorial
API用法实例，用于QA培训课程演示


com.vlife.qa.ui
常用布局，控件的常用方法


com.vlife.qa.util
工具类，整合测试结果、辅助快速调试
