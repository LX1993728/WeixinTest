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
 		  'image':'../img/person/web/救援力量1.png',
 		  'text':'公安1',
 		  'lonlat':[113.9828,22.584842],

 		},
 		{
 		  'id':'publicSecurity',
 		  'image':'../img/person/web/救援力量1.png',
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
 		  'image':'../img/person/web/救援力量查找拷贝6.png',
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
 		  'image':'../img/person/web/危险拷贝.png',
 		  'text':'自然灾害1',
 		  'lonlat':[113.9028,22.484842],

 		},
 		{
 		  'id':'naturalDisaster',
 		  'image':'../img/person/web/危险拷贝.png',
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
          'image':'../img/person/web/危险拷贝2.png',
          'text':'事故灾难1',
          'lonlat':[113.9428,22.400842],

        },
        {
          'id':'sgDisaster',
          'image':'../img/person/web/危险拷贝2.png',
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
          'image':'../img/person/web/危险拷贝3.png',
          'text':'公共卫生1',
          'lonlat':[113.43428,22.405842],

        },
        {
          'id':'ggws',
          'image':'../img/person/web/危险拷贝3.png',
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
          'image':'../img/防护目标/web/重点.png',
          'text':'事故灾难1',
          'lonlat':[113.9828,22.584842],

        },
        {
          'id':'zdfh',
          'image':'../img/防护目标/web/重点.png',
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

}
