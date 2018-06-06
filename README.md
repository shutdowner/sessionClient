本项目主要用于实现Session控制器(实现client端)
主要流程：
	1、主线程会并发的新建10个session
	2、每个session会有start和stop操作
	3、start操作首先会调用http请求，告诉服务器自己开始了，然后会异步调用stop
	4、本项目中的stop是根据session的时长自动调用，采取的时timer+线程池实现异步调用
	5、项目会在所有session均stop之后才会结束
	
注：本项目支持的功能有： 1、支持异步发送  使用timer定时加线程池
					   2、支持动态调整并发参数  通过配置文件控制
					   3、支持动态调整所有session时长 通过配置文件控制
					   4、 有异常处理
					   5、所有session均执行完才会停止
