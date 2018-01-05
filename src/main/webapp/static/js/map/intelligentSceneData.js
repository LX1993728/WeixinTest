var intelligentScene = {

    //船
    getBoatData : function getBoatData(){
 		var map = {};
 		//客船
 		var KCData = [
 		{ 
 		  'id':'KC',
 		  'image':'../img/web/多边形3拷贝6.png',
 		  'text':'客船1',
 		  'lonlat':[113.9828,22.584842],

 		},
 		{
 		  'id':'KC',
 		  'image':'../img/web/多边形3拷贝6.png',
 		  'text':'客船2',
 		  'lonlat':[114.118755,22.602593],
 		},
 		];
        //货船
 		var HCData =[
 		{
 		  'id':'HC',
 		  'image':'../img/web/多边形3拷贝7.png',
 		  'text':'货船1',
 		  'lonlat':[114.050091,22.644424],

 		},
 		];

 		//执法船
 		var ZFCData =[
 		{
 		  'id':'ZFCData',
 		  'image':'../img/执法船.png',
 		  'text':'执法1',
 		  'lonlat':[114.050391,22.644424],

 		},
 		];
 		//拖轮
 		var TLData =[
 		{
 		  'id':'TLData',
 		  'image':'../img/web/多边形3拷贝8.png',
 		  'text':'拖轮1',
 		  'lonlat':[114.050491,22.644424],

 		},
 		];

 		//搜救船
 		var SJCData =[
 		{
 		  'id':'SJCData',
 		  'image':'../img/web/多边形3拷贝9.png',
 		  'text':'搜救船1',
 		  'lonlat':[114.050591,22.644424],

 		},
 		];


        map['KCData'] = KCData;
        map['HCData'] = HCData;
        map['ZFCData'] = ZFCData;
        map['TLData'] = TLData;
        map['SJCData'] = SJCData;
        return map;
    },
    
    
   
    
    //房屋统计
    getHouseData : function getHouseData(){
 		var map = {};
 		//场所
 		var place = 
 		[
 		{ 
 		  'id':'place',
 		  'image':'../img/web/场所.png',
 		  'text':'place1',
 		  'lonlat':[113.9828,22.684842],
 		  'personNum':20,
 		  'tel':"0755-23123454"


 		},
 		{
 		  'id':'place',
 		  'image':'../img/web/场所.png',
 		  'text':'place2',
 		  'lonlat':[114.118755,22.602593],
 		  'personNum':30,
 		  'tel':"0755-23123454"
 		},
 		];
        //法人单位
 		var company =
        [
 		{
 		  'id':'company',
 		  'image':'../img/web/法人办事.png',
 		  'text':'company1',
 		  'lonlat':[114.050091,22.644424],
 		  'personNum':300,
 		  'tel':"0755-23123454"

 		},
 		];
 		//船舶
 		var boat =
        [
 		{
 		  'id':'boat',
 		  'image':'../img/web/船.png',
 		  'text':'boat1',
 		  'lonlat':[114.153491,22.647424],
 		  'personNum':200,
 		  'tel':"0755-23123454"

 		},
 		{
 		  'id':'boat',
 		  'image':'../img/web/船.png',
 		  'text':'boat2',
 		  'lonlat':[114.153491,22.747424],
 		  'personNum':278,
 		  'tel':"0755-23123454"

 		},
 		];
        map['place'] = place;
        map['company'] = company;
        map['boat'] = boat;
        return map;
    },
    


}
