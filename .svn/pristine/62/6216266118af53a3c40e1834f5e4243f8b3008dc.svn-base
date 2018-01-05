
$(function(){

	//底部移入效果

	$(".baseOption>ul>li").mouseover(function() {
		$(this).find('ul').show();
	});
	$(".baseOption>ul>li").mouseout(function() {
		$(this).find('ul').hide();
	});

	//左侧收起功能
	$(".packUp").click(function(){
		$(this).parents('.l_reveal').toggleClass("fewer");
		$(this).toggleClass("packUpOpen");
		$(this).hide();
	})

	//左测点击显示

	$(document).on('click', '.l_wicket>div', function() {
		$(".packUp").show();
		$(".l_reveal").addClass("fewer");
		$(".packUp").addClass("packUpOpen");
		var _current = $(this);
		var odiv = $(".details>div")[_current.index()];
		$($(odiv).siblings("div")).hide();
		$(odiv).show();
		var bg = $(".backdrop")[_current.index()];
		$(bg).addClass("hue").siblings("li").removeClass("hue");



		//与地图互动
		console.log(_current.children(":first").html())
		var flagDivHtml = _current.children(":first").html();
		if(flagDivHtml== '任务动态'){
			initDynamicTask();
		}else if(flagDivHtml == '物资调配'){
			initAllocateSupplies();

		}

	});

	$('.switchover').on('click', 'li', function() {
		$(this).addClass("hue").siblings("li").removeClass("hue");
		var _current = $(this);
		var odiv = $(".details>div")[_current.index()];
		$($(odiv).siblings("div")).hide();
		$(odiv).show();

		//与地图互动
		if(_current.html() == '人员调度'){
			initPersonDispatcher();
		}else if(_current.html() == '任务动态'){
			initDynamicTask();

		}else{
			initAllocateSupplies();
		}
	});

    
	//人员调度组织机构点击事件
	$(document).on("click",".showList",function(){
		$(".showList").removeClass("z_bg");
		$(this).addClass("z_bg");
		//$(this).siblings("ul").hide();
		$(this).next("ul").toggleClass("r_show");
		$(this).find(".w_png").toggleClass("z_img");
	})
	var oldUserStatus;
	//人员调度组织机构下人员点击事件
	$(document).on("click",".staffDetails",function(){
		$(".SearchShow>ul>li>ul>li").removeClass("z_l_bg");
		$(this).addClass("z_l_bg");

		//地图此人高亮
		if(oldUserStatus){
			oldUserStatus.image = 'img/person/web/wei.png';
			if(oldUserStatus.online){
				createHighlightMarker(oldUserStatus);
			}
		}
		var data = $(this).attr("data");
		var user = JSON.parse(data);
		oldUserStatus = user;
		user.image = 'img/person/web/gao.png';
		if(user.online){
			map.setCenter(user.lonlat);
			createHighlightMarker(user);
		}
		mouseTool.close();

	})
	//任务动态的点击事件
	var oldTaskStatus;
	$(document).on("click",".d_mission .trends",function(){

		//地图此人高亮
		if(oldTaskStatus){
			oldTaskStatus.image = 'img/point.png';
			createHighlightTaskMarker(oldTaskStatus);
			
		}

		//var data = $(this).closest(".trends").attr("data");
		var task = JSON.parse($(this).attr("data"));
		oldTaskStatus = task;
		task.image = 'img/task_highlight.png';
		map.setCenter(task.lonlat);
		createHighlightTaskMarker(task);
		
	})






	//物资调配
	$(".listing_details").click(function(){
		$(this).siblings("div").toggleClass("r_show");
		$(this).find(".w_png").toggleClass("w_img");
	})


	//
	/*$(".navigation>li>p").click(function(){
		$(this).siblings("ul").toggleClass('r_show');
		$(this).toggleClass('n_col');
	})*/
	//头部点击显示
	$(".aptitude").click(function(){
		$(this).siblings("ul").toggleClass('r_show');
	})
	//搜索筛选范围
	$("#choose_l").click(function(){
		$(".choose_l_spread").show();
		$(".choose_r").addClass("filtrate")
		
	})
	$(".choose").click(function(){
		$(".choose_l_spread").show();
		$(".choose_r").addClass("filtrate");
	})
	$(".choose_l_spread>div").click(function(){
		window.event? window.event.cancelBubble = true : e.stopPropagation();
		$("#choose_l").text($(this).text());
		$(".choose_l_spread").hide();
		$(".choose_r").removeClass("filtrate");
	})
	//右侧测试搜索的假json

var grabble = {"data" : [
	{"kind":"防化服","site":"福田区环境应急储备所1","amount":"10", "store":"福田区环境应急储备"},
	{"kind":"轻型防化服","site":"福田区环境应急储备所2","amount":"10","store":"罗湖区环境应急储备"},
	{"kind":"防化服","site":"福田区环境应急储备所3","amount":"20","store":"宝安区环境应急储备"},
	{"kind":"轻型防化服","site":"福田区环境应急储备所4","amount":"20","store":"盐田区环境应急储备"},
]}


var primary = $(".site").html();
var second = $(".Commodity").html();

$(".huntIcon").click(function(){
	//显示筛选的范围
	var txt = $("#choose_l").text().toString().trim();
	console.log(txt)
	if(txt == "场所"){
		$(".r_s_show>div:nth-child(2)").hide();
		$(".r_s_show>div:nth-child(1)").show();
	}
	else if(txt == "物资"){
		$(".r_s_show>div:nth-child(2)").show();
		$(".r_s_show>div:nth-child(1)").hide();
	}
	else{
		$(".r_s_show>div").show();
	}
	
	$(".r_s_show").show();
	var data = grabble.data;
	var tally = '',wheel='';
	console.log(data[1].kind);
		
	//删除从第二个节点的元素
	$(".site>li").remove();
	$(".site").html(primary);
	
	$(".Commodity>li").remove();
	$(".Commodity").html(second);
	var collect = $(".huntFrame").val() + "";
	var matter = collect.length;
	console.log(matter)
	var amount = 0;
	for(var i=0;i<data.length;i++){
		if(data[i].kind.indexOf(collect)!=-1 && matter != 0){
			//场所
			tally +='<li class="presentationCacheClassify">';
			tally += "<div class='classify_l'>" + data[i].kind + "</div>";
			tally += "<div class='classify_c'>" + data[i].site + "</div></li>";
			//物资
			wheel += '<li class="presentationCacheClassify">';
			wheel += "<div class='classify_l'>" + data[i].kind + "</div>";
			wheel += "<div class='classify_c'>" + data[i].store + "</div>";
			wheel += "<div class='classify_r'>" + data[i].amount + "</div></li>";
			
			amount++
		}
	}
	$("#site").text(amount);
	$(".site").append(tally);
	$(".Commodity").append(wheel);
	$("#Commodity").text(amount);
	
})

$(".r_s_show_header>u").click(function(){
	var spn = $(this).children('span');
	if($(spn).text() == "展开") {
		$(spn).text("收起");
		} else {
		$(spn).text("展开");
	};
	$(this).parent(".r_s_show_header").siblings(".presentationCache").toggleClass("hd");
})

//搜索框获取焦点隐藏筛选下拉框
$(".huntFrame").focus(function(){
	$(".choose_l_spread").hide();
	$(".choose_r").removeClass("filtrate");
	//显示筛选的范围
	var txt = $("#choose_l").text().toString().trim();
	console.log(txt)
	if(txt == "场所"){
		$(".r_s_show>div:nth-child(2)").hide();
		$(".r_s_show>div:nth-child(1)").show();
	}
	else if(txt == "物资"){
		$(".r_s_show>div:nth-child(2)").show();
		$(".r_s_show>div:nth-child(1)").hide();
	}
	else{
		$(".r_s_show>div").show();
	}
})

//任务动态刷新

var man = {"map" : [
	{"section":"信息材料组","condition":"已赶赴现场签到。"},
	{"section":"警戒交通管控组","condition":"现场车辆拥堵严重，已安排交警进行车辆疏导，建议交委通过广播、电视通告等方式进行交通管制，减轻现场交通压力。","route":"img/u2805.png"},
	{"section":"工程抢险组","condition":"现场火势较大，消防车辆已进行救火扑灭工作，火势得到基本控制。但是燃油泄露严重，容易引发次生灾害，建议安排泡沫扑灭","route":"img/u2815.png"},
	{"section":"危险化学品应急处置组","condition":"已赶赴现场签到"},
	{"section":"工程抢险组","condition":"已赶赴现场签到"},
	{"section":"警戒交通管控组","condition":"已赶赴现场签到"},
	{"section":"武警调配组","condition":"已赶赴现场报道"},
]}

//console.log(man.map[1].route)
setInterval(function(){
//	console.log(man.map[1].section)
	
	var date = new Date(),
		month = date.getMonth() + 1,
		day = date.getDate(),
		hour = date.getHours(),
		mins = date.getMinutes();
	if(month < 10) {
		month = "0" + month;
	}
	if(day < 10) {
		day = "0" + day;
	}
	if(mins < 10) {
		mins = "0" + mins;
	}
	if(hour < 10) {
		hour = "0" + hour;
	}
	var present = month + "-" + day + " " + hour + ":" + mins;
	
	var stochastic = Math.floor(Math.random()*7);
//	console.log( man.map[stochastic].section)
	
	var str = "";
	str += '<li class="staff"><div class="posture"><div>态势回转: <span>' + man.map[stochastic].section + '</span></div><div></div>';
	str += '<div>' + present + '</div></div>';
	str += '<div class="substance"><div>' + man.map[stochastic].condition + '</div>';
	if(man.map[stochastic].route != undefined){
		str += '<div><img src="'+ man.map[stochastic].route +'" style="width: 100%;height: 100%;"/></div></div></li>';
	}
	
	str +="</div></li>"
	$(str).insertBefore($(".trends>ul>li:nth-child(1)"));
	
},30000)
//人员调度搜索功能

/*var branch = {
	"data" : [
		{"section" : "现场指挥部",
		 "name" : ["现场指挥部","现场指挥部2","现场指挥部3"],
		 "onLine" : "3"
		},
		{"section" : "现场总指挥部办公室",
		 "name" : ["现场总指挥部办公室","现场总指挥部办公室2","现场总指挥部办公室3","现场总指挥部办公室4","现场总指挥部办公室5","现场总指挥部办公室6","现场总指挥部办公室7","现场总指挥部办公室8","现场总指挥部办公室9"],
		  "onLine" : "5"
		},
		{"section" : "综合协调组",
		 "name" : ["综合协调组1","综合协调组2","综合协调组3","综合协调组4","综合协调组5","综合协调组6","综合协调组7","综合协调组8","综合协调组9"],
		  "onLine" : "7"
		},
		{"section" : "信息材料组",
		 "name" : ["信息材料组1","信息材料组2","信息材料组3","信息材料组4","信息材料组5","信息材料组6","信息材料组7"],
		  "onLine" : "6"
		},
		{"section" : "舆情综合协调组",
		 "name" : ["舆情综合协调组","舆情综合协调组","舆情综合协调组","舆情综合协调组","舆情综合协调组","舆情综合协调组","舆情综合协调组","舆情综合协调组","舆情综合协调组"],
		  "onLine" : "5"
		},
		{"section" : "接待服务组",
		 "name" : ["接待服务组1","接待服务组2","接待服务组3","接待服务组4","接待服务组5","接待服务组6","接待服务组7","接待服务组8","接待服务组9"],
		  "onLine" : "4"
		},
		{"section" : "事故调查配合组",
		 "name" : ["事故调查配合组1","事故调查配合组2","事故调查配合组3","事故调查配合组4","事故调查配合组5","事故调查配合组6","事故调查配合组7","事故调查配合组8","事故调查配合组9"],
		  "onLine" : "3"
		},
		{"section" : "安保交通指挥组",
		 "name" : ["安保交通指挥组1","安保交通指挥组2","安保交通指挥组3","安保交通指挥组4","安保交通指挥组5","安保交通指挥组6","安保交通指挥组7","安保交通指挥组8","安保交通指挥组9"],
		  "onLine" : "6"
		},
		{"section" : "军地联动协调组",
		 "name" : ["军地联动协调组1","军地联动协调组2","军地联动协调组3","军地联动协调组4","军地联动协调组5","军地联动协调组6","军地联动协调组7","军地联动协调组8","军地联动协调组9"],
		  "onLine" : "4"
		},
		{"section" : "医疗卫生保障组",
		 "name" : ["医疗卫生保障组1","医疗卫生保障组2","医疗卫生保障组3","医疗卫生保障组4","医疗卫生保障组5","医疗卫生保障组6","医疗卫生保障组7","医疗卫生保障组8","医疗卫生保障组9"],
		  "onLine" : "5"
		},
		{"section" : "后勤保障组",
		 "name" : ["后勤保障组1","后勤保障组2","后勤保障组3","后勤保障组4","后勤保障组5","后勤保障组6","后勤保障组7","后勤保障组8","后勤保障组9"],
		  "onLine" : "7"
		},
		{"section" : "善后工作组",
		 "name" : ["善后工作组1","善后工作组2","善后工作组3","善后工作组4","善后工作组5","善后工作组6","善后工作组7","善后工作组8","善后工作组9"],
		  "onLine" : "2"
		},
		{"section" : "抢险救援工作组",
		 "name" : ["抢险救援工作组1","抢险救援工作组2","抢险救援工作组3","抢险救援工作组4","抢险救援工作组5","抢险救援工作组6","抢险救援工作组7","抢险救援工作组8","抢险救援工作组9"],
		  "onLine" : "9"
		},
	],
	
}
//console.log(branch.data[0].section)

function callBack(){
	
	//人员调度
	$(".showList").click(function(){
		$(".showList").removeClass("z_bg");
		$(this).addClass("z_bg");
		$(this).siblings("ul").toggleClass("r_show");
		$(this).find(".x_icon").toggleClass("z_img");
	})
	$(".staffDetails").click(function(){
		$(".SearchShow>ul>li>ul>li").removeClass("z_l_bg");
		$(this).addClass("z_l_bg");
		$(".staffDetails").find(".troops").removeClass("multi");
		$(this).find(".troops").toggleClass("multi");
	})
	
}

	var crew = '';
	var ransack = $(".staffSearch>input").val()+"";
	var consequence = ransack.length;
	for(i=0;i<branch.data.length;i++){
		var nam = branch.data[i].name;
			console.log(nam);
			debugger;
			crew += '<li><div class="showList">';
			crew += '<div class="showList_headline">' + branch.data[i].section + '<span>(' + branch.data[i].onLine +  "/" + nam.length + ')</span></div>';
			crew += '<div class="w_png x_icon"></div></div><ul>';
			for(j=0;j<nam.length;j++){
				crew += '<li class="staffDetails"><div><input type="checkbox"/></div>';
				crew += '<div class="troops">' + nam[j] + '</div><div>音频</div><div>视频</div></li>';
			}
			crew += "</ul></li>";
	}
		$(".SearchShow>ul").append(crew);


$(".startSeek").click(function(){
	var crew = '';
	var ransack = $(".staffSearch>input").val()+"";
	var consequence = ransack.length;
	for(i=0;i<branch.data.length;i++){
		if(branch.data[i].section.indexOf(ransack) != -1 && consequence != 0){
			var nam = branch.data[i].name;
			console.log(nam);
			debugger;
			crew += '<li><div class="showList">';
			crew += '<div class="showList_headline">' + branch.data[i].section + '<span>(' + branch.data[i].onLine +  "/" + nam.length + ')</span></div>';
			crew += '<div class="w_png x_icon"></div></div><ul>';
			for(j=0;j<nam.length;j++){
				crew += '<li class="staffDetails"><div><input type="checkbox"/></div>';
				crew += '<div class="troops">' + nam[j] + '</div><div>音频</div><div>视频</div></li>';
			}
			crew += "</ul></li>";
		}
	}
	$(".SearchShow>ul").html("");
	$(".SearchShow>ul").append(crew);
	
	callBack();
	})*/
});
