var personnelDispatch = {

    
    //防护目标

    //避难场所
	
	//救援力量
    
   
    //医疗卫生
    //物资储备
    //水电气管网
    //交通消防
    //实时监控

    getAllData : function getAllData(){
    
    	var map = {};
 		////救援力量 公安
 		var publicSecurity = {
 		'checked':false,
 		'data':[
 		{ 
 		  'id':'publicSecurity',
 		  'image':'img/person/web/救援力量1.png',
 		  'text':'公安1',
 		  'lonlat':[113.9828,22.584842],

 		},
 		{
 		  'id':'publicSecurity',
 		  'image':'img/person/web/救援力量1.png',
 		  'text':'公安2',
 		  'lonlat':[114.118755,22.602593],
 		},
 		]};
        //特勤
 		var specialPoliceman ={
        'checked':false,
        'data':[
 		{
 		  'id':'specialPoliceman',
 		  'image':'img/person/web/救援力量查找拷贝6.png',
 		  'text':'特警1',
 		  'lonlat':[114.050091,22.644424],

 		},
 		]};
 		//危险源 自然灾害
 		var naturalDisaster = {
 		'checked':false,
 		'data':[
 		{ 
 		  'id':'naturalDisaster',
 		  'image':'img/person/web/危险拷贝.png',
 		  'text':'自然灾害1',
 		  'lonlat':[113.9028,22.484842],

 		},
 		{
 		  'id':'naturalDisaster',
 		  'image':'img/person/web/危险拷贝.png',
 		  'text':'自然灾害2',
 		  'lonlat':[114.318755,22.625593],
 		},
 		]};
 		//危险源 事故灾难
        var sgDisaster = {
        'checked':false,
        'data':[
        { 
          'id':'sgDisaster',
          'image':'img/person/web/危险2.png',
          'text':'事故灾难1',
          'lonlat':[113.9428,22.400842],

        },
        {
          'id':'sgDisaster',
          'image':'img/person/web/危险2.png',
          'text':'事故灾难2',
          'lonlat':[113.318755,21.625593],
        },
        ]};
        //危险源 公共卫生
        var ggws = {
        'checked':false,
        'data':[
        { 
          'id':'ggws',
          'image':'img/person/web/危险拷贝3.png',
          'text':'公共卫生1',
          'lonlat':[113.43428,22.405842],

        },
        {
          'id':'ggws',
          'image':'img/person/web/危险拷贝3.png',
          'text':'公共卫生2',
          'lonlat':[113.448755,21.345593],
        },
        ]};
         //防护目标 重点防护
        var zdfh = {
        'checked':false,
        'data':[
        { 
          'id':'zdfh',
          'image':'img/防护目标/web/重点.png',
          'text':'事故灾难1',
          'lonlat':[113.9828,22.584842],

        },
        {
          'id':'zdfh',
          'image':'img/防护目标/web/重点.png',
          'text':'事故灾难2',
          'lonlat':[113.9028,22.784842],
        },
        ]};
        map['publicSecurity'] = publicSecurity;
        map['specialPoliceman'] = specialPoliceman;
        map['naturalDisaster'] = naturalDisaster;
        map['sgDisaster'] = sgDisaster;
        map['ggws'] = ggws;
        return map;

    },

   //人员调度
   getPersonData : function getPersonData(){
       var array = [
       {
        deptId:'ZZH001',
        deptName:'现场总指挥部',
        deptUser:[
	        {
	          'userId':'8',
	          'userName':'现场总指挥官',
	          'lonlat':[113.9828,22.584842],
	          'online':true,
	          'image':'img/person/web/wei.png',
	          'parentId':'ZZH001'
	        },
	        {
			  'userId':'9',
	          'userName':'现场副指挥官',
	          'image':'img/person/web/wei.png',
	          'lonlat':[113.9828,22.674842],
	          'online':true,
	          'parentId':'ZZH001'
	        },
	        {
	          'userId':'ZZH0013',
	          'userName':'现场人员',
	          'image':'img/person/web/wei.png',
	          'lonlat':[113.9828,22.424842],
	          'online':false,
	          'parentId':'ZZH001'
	        }
            ]
       },
       {
        deptId:'SZH002',
        deptName:'现场总指挥办',
        deptUser:[
	        {
	          'userId':'10',
	          'userName':'现场总指挥办1',
	          'image':'img/person/web/wei.png',
	          'lonlat':[114.146221,22.609566],
	          'online':true,
	          'parentId':'SZH002'
	        },
	        {
			  'userId':'11',
	          'userName':'现场总指挥办2',
	          'image':'img/person/web/wei.png',
	          'lonlat':[114.076183,22.63682],
	          'online':true,
	          'parentId':'SZH002'
	        },
	        {
	          'userId':'SZH0023',
	          'userName':'现场总指挥办3',
	          'image':'img/person/web/wei.png',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH002'
	        }
            ]

       },
       {
        deptId:'SZH003',
        deptName:'综合协调组',
        deptUser:[
	        {
	          'userId':'SZH0031',
	          'userName':'综合协调组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH003'
	        },
	        {
			  'userId':'SZH0032',
	          'userName':'综合协调组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH003'
	        },
	        {
	          'userId':'SZH0033',
	          'userName':'综合协调组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH003'
	        }
            ]

       },
       {
        deptId:'SZH004',
        deptName:'信息材料组',
        deptUser:[
	        {
	          'userId':'SZH0041',
	          'userName':'信息材料组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH004'
	        },
	        {
			  'userId':'SZH0042',
	          'userName':'信息材料组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH004'
	        },
	        {
	          'userId':'SZH0043',
	          'userName':'信息材料组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH004'
	        }
            ]

       },
       {
        deptId:'SZH005',
        deptName:'舆情综合协调组',
        deptUser:[
	        {
	          'userId':'SZH0051',
	          'userName':'舆情综合协调组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH005'
	        },
	        {
			  'userId':'SZH0052',
	          'userName':'舆情综合协调组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH005'
	        },
	        {
	          'userId':'SZH0053',
	          'userName':'舆情综合协调组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH005'
	        }
            ]

       },
       {
        deptId:'SZH006',
        deptName:'接待服务组',
        deptUser:[
	        {
	          'userId':'SZH0061',
	          'userName':'接待服务组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH006'
	        },
	        {
			  'userId':'SZH0062',
	          'userName':'接待服务组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH006'
	        },
	        {
	          'userId':'SZH0063',
	          'userName':'接待服务组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH006'
	        }
            ]

       },
       {
        deptId:'SZH007',
        deptName:'事故调查配合组',
        deptUser:[
	        {
	          'userId':'SZH0071',
	          'userName':'事故调查配合组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH007'
	        },
	        {
			  'userId':'SZH0072',
	          'userName':'事故调查配合组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH007'
	        },
	        {
	          'userId':'SZH0073',
	          'userName':'事故调查配合组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH007'
	        }
            ]

       },
       {
        deptId:'SZH008',
        deptName:'安保交通指挥组',
        deptUser:[
	        {
	          'userId':'SZH0081',
	          'userName':'安保交通指挥组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH008'
	        },
	        {
			  'userId':'SZH0082',
	          'userName':'安保交通指挥组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH008'
	        },
	        {
	          'userId':'SZH0083',
	          'userName':'安保交通指挥组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH008'
	        }
            ]

       },
       {
        deptId:'SZH009',
        deptName:'军地联动协调组',
        deptUser:[
	        {
	          'userId':'SZH0091',
	          'userName':'军地联动协调组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH009'
	        },
	        {
			  'userId':'SZH0092',
	          'userName':'军地联动协调组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH009'
	        },
	        {
	          'userId':'SZH0093',
	          'userName':'军地联动协调组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH009'
	        }
            ]

       },
       {
        deptId:'SZH0010',
        deptName:'医疗卫生保障组',
        deptUser:[
	        {
	          'userId':'SZH00101',
	          'userName':'医疗卫生保障组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH0010'
	        },
	        {
			  'userId':'SZH00102',
	          'userName':'医疗卫生保障组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH002'
	        },
	        {
	          'userId':'SZH00103',
	          'userName':'医疗卫生保障组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH0010'
	        }
            ]

       },
       {
        deptId:'SZH0011',
        deptName:'后勤保障组',
        deptUser:[
	        {
	          'userId':'SZH00111',
	          'userName':'后勤保障组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH0011'
	        },
	        {
			  'userId':'SZH00112',
	          'userName':'后勤保障组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH0011'
	        },
	        {
	          'userId':'SZH00113',
	          'userName':'后勤保障组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH0011'
	        }
            ]

       },
       {
        deptId:'SZH0012',
        deptName:'善后工作组',
        deptUser:[
	        {
	          'userId':'SZH00121',
	          'userName':'善后工作组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH0012'
	        },
	        {
			  'userId':'SZH00122',
	          'userName':'善后工作组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH0012'
	        },
	        {
	          'userId':'SZH00123',
	          'userName':'善后工作组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH0012'
	        }
            ]

       },
       {
        deptId:'SZH0013',
        deptName:'善后工作组',
        deptUser:[
	        {
	          'userId':'SZH00131',
	          'userName':'善后工作组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH0013'
	        },
	        {
			  'userId':'SZH00132',
	          'userName':'善后工作组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH0013'
	        },
	        {
	          'userId':'SZH00133',
	          'userName':'善后工作组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH0013'
	        }
            ]

       },
       
       {
        deptId:'SZH0014',
        deptName:'抢险救援工作组',
        deptUser:[
	        {
	          'userId':'SZH00141',
	          'userName':'抢险救援工作组1',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0828,22.424842],
	          'online':false,
	          'parentId':'SZH0014'
	        },
	        {
			  'userId':'SZH00142',
	          'userName':'抢险救援工作组2',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.1500,22.424842],
	          'online':false,
	          'parentId':'SZH0014'
	        },
	        {
	          'userId':'SZH00143',
	          'userName':'抢险救援工作组3',
	          'image':'img/用户拷贝.jpg',
	          'lonlat':[114.0889,22.424842],
	          'online':false,
	          'parentId':'SZH0014'
	        }
            ]

       }
       
       ];

       return array;
   },



   getTaskData:function getTaskData(){

   		 var array = [
	       {
	         'taskId':'task1',
	         'taskTitle':"态势回转:",
	         'taskName':"信息材料组",
	         'image':'img/point.png',
	         'lonlat':[114.419273,22.628954], //葵涌汽车站
	         'flag':'task',
	         'text':'现场车辆拥堵严重，已安排交警进行车辆疏导，建议交委通过广播、电视通告等方式进行交通管制，减轻现场交通压力。',
             'taskImg':'img/u2805.png'

	        
	       },
	       {
	         'taskId':'task2',
	         'taskTitle':"态势回转:",
	         'taskName':"信息材料组",
	         'image':'img/point.png',
	         'lonlat':[114.473244, 22.596336],//大鹏汽车站
	         'flag':'task',
	         'text':'现场车辆拥堵严重，已安排交警进行车辆疏导，建议交委通过广播、电视通告等方式进行交通管制，减轻现场交通压力。',
             'taskImg':'img/u2805.png'
	        
	       },
	    ]
	    return array;
   }


}
