<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>浙大宠物医院</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name="applicable-device" content="mobile">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	
</head>
<body>
	<div id="container">
		<header>
			<div class="tc white head-title f20">
				<i class="fa fa-plus-square"></i>
				医疗团队
			</div>
		</header>
		<div class="floor">
			<div id="slier" class="sliderWrapper tc">
				<ul class="newSlide" id="sliderTouch">
					<li class="slideLi">
						<a href="#">
							<img src="<%=request.getContextPath()%>/images/banner.jpg">
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="groom">
			<div class="griy-bg h20">
				
			</div>
			<h3 class="groom-title">
				团队介绍
			</h3>
			<div class="groom-list overflow">
				<ul>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/1.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">胡松华 博士 教授 院长</font>
								</div>
								<div>
									<font size="3px">2002年毕业于瑞典皇家兽医学院,现担任浙江大学动物医学系主任,擅长中西医结合犬猫疾病的临床诊断,目前担任中国畜牧兽医学会分会副理事长,中国收益药典委员会委员。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/2.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">杜爱芳  博士，教授</font>
								</div>
								<div>
									<font size="3px">2004年毕业于浙江大学动物医学专业，现担任浙江大学动物科学学院副院长，擅长犬猫等动物寄生虫，皮肤病的诊治。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/3.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">邵庆军 博士 教授</font>
								</div>
								<div>
									<font size="3px">1989年毕业于泰国亚洲理学院,擅长水族及两栖动物的营养学及疾病的临床诊断与治疗。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/4.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">李肖梁，博士，研究员</font>
								</div>
								<div>
									<font size="3px">主要研究方向动物病原与免疫学，浙江省畜牧兽医学会兽医公共卫生与畜产品安全分会常务理事。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/5.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">郑肖娟 ，博士</font>
								</div>
								<div>
									<font size="3px">2002年毕业于浙江大学动物科学学院动物医学专业，获学士学位。2007年毕业于浙江大学动物科学学院微生物专业，获博士学位。现任浙江大学动物科学学院讲师，农业部动物病毒学重点实验室骨干，主要从事动物传染病的预防、病原诊断研究和兽医微生物学的教学工作。2012~2015年期间，先后在美国圣路易斯华盛顿大学医学院和美国加州大学洛杉矶分校医学院进修三年，从事分子病毒学和抗病毒药物的研究。目前为浙江省免疫学会理事，中国免疫学会会员，美国微生物协会会员。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/6.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">廖敏，博士后</font>
								</div>
								<div>
									<font size="3px">2007年毕业于日本岐阜大学，获兽医学博士学位，2007-2009年，日本JSPS资助在日本鹿儿岛大学做博士后研究工作。2013-2014年到美国约翰霍普金斯大学做短期访问学者。现为浙江大学动物科学学院副研究员，硕士生导师，教育部新世纪人才获得者，农业部动物病毒学重点实验室副主任。主要从事兽医专业理论课教学和动物疫病防控技术研究。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/7.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">谭勋，博士后</font>
								</div>
								<div>
									<font size="3px">2004年毕业于南京农业大学动物医学临床兽医专业，获博士学位。2007年浙江大学博士后流动站出站，同年应聘于浙江大学动物科学学院动物医学系承担教学和科研工作。2009-2010年作为访问学者赴美国北卡州立大学兽医学院进行访问研究。现任浙江大学副教授，硕士生导师，动物医学系副主任，入选浙江大学青年骨干教师培养计划。主要兽医病理学教学和研究工作，擅长病理学组织学诊断。目前担任中国兽医学会兽医内科学分会常务理事、中国畜牧兽医学会兽医病理学分会理事。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/8.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">师福山  博士.主治医生</font>
								</div>
								<div>
									<font size="3px">2013年毕业于中国农业大学动物医学专业,获国家执业兽医资格证书,擅长犬猫肿瘤病理和内科疾病的诊治。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/9.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">李剑，博士</font>
								</div>
								<div>
									<font size="3px">浙江大学动物科学学院基础兽医系讲师，主讲本科生《动物解剖学》，科研上主要从事消化系统发育研究，临床方面擅长动物剖检、医学影像等技术。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/10.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">王华南 博士 主治医师</font>
								</div>
								<div>
									<font size="3px">2013年留学于美国明尼苏达大学，2015年毕业于中国农业大学兽医专业，获博士学位，现任浙江大学临床兽医系讲师。擅长外科手术、肿瘤学、牙科、皮肤病等。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/11.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">季常青  学士，助理研究员，常务副院长</font>
								</div>
								<div>
									<font size="3px">1982年毕业于原浙江农业大学兽医专业，擅长犬猫等动物内科疾病的临床诊断与治疗</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/12.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">王祖锁  硕士.副教授 ,副院长</font>
								</div>
								<div>
									<font size="3px">1986年毕业于中国农业大学动物医学专业,擅长犬猫等动物内科病、中毒性疾病的临床诊断与治疗。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/13.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">朱国  博士，主治医生，副院长</font>
								</div>
								<div>
									<font size="3px">2004年毕业于南京农业大学动物医学专业，2009年新加坡小动物康复中心学习，获国家执业兽医资格证书，擅长犬猫普外科，皮肤病，肿瘤性疾病的临床诊断与治疗。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/14.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">陈柏良  硕士，主治医生</font>
								</div>
								<div>
									<font size="3px">2012年毕业于扬州大学畜牧兽医专业，获国家执业兽医资格证书，擅长犬猫全科疾病的临床诊断与治疗。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/15.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">刘英龙 硕士 主治医师</font>
								</div>
								<div>
									<font size="3px">2000年毕业于南京农业大学兽医专业，获国家执业兽医资格证书，擅长犬猫疾病及反刍动物疾病的诊断与治疗。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/16.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">刘洁 硕士 主治医师</font>
								</div>
								<div>
									<font size="3px">2015年毕业于华中农业大学兽医专业，获国家执业兽医资格证书，擅长犬猫疾病的诊断与治疗。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/17.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">吴伟鹏 硕士 主治医师</font>
								</div>
								<div>
									<font size="3px">2015年毕业于北京农学院兽医专业，获国家执业兽医资格证书，擅长中西医结合治疗诊断和治疗犬猫疾病。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/18.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">薛银 硕士 主治医师</font>
								</div>
								<div>
									<font size="3px">2014年毕业于浙江大学临床兽医专业，获国家执业兽医资格证书，擅长中西医结合诊疗犬猫疾病。</font>
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="avatar fl">
							<div class="avatar-box">
								<img src="<%=request.getContextPath()%>/images/team/19.jpg" width="100%" height="100%">
							</div>
						</div>
						<div class="grrom-brev fl">
							<div class="brev-box">
								<div class="grrom-time griy">
									<font size="4px">吴明  学士 主治医师</font>
								</div>
								<div>
									<font size="3px">2014年毕业于海南大学动物医学专业,获国家执业兽医资格证书,主管重症监护,术后护理及临床治疗。</font>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="griy-bg h20">
				
			</div>
		</div>
	</div>
</body>
</html>