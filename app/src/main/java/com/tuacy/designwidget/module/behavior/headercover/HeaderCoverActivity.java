package com.tuacy.designwidget.module.behavior.headercover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tuacy.designwidget.R;
import com.tuacy.designwidget.app.BaseMobileActivity;

import java.util.ArrayList;
import java.util.List;


public class HeaderCoverActivity extends BaseMobileActivity {

	public static void startup(Context context) {
		context.startActivity(new Intent(context, HeaderCoverActivity.class));
	}

	private RecyclerView mRecyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_header_cover);
		initView();
		initEvent();
		initData();
	}

	private void initView() {
		mRecyclerView = findViewById(R.id.recycler_item_display);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
	}

	private void initEvent() {
	}

	private void initData() {
		mRecyclerView.setAdapter(new CityAdapter(obtainData()));
	}

	private List<String> obtainData() {
		List<String> data = new ArrayList<>();
		data.add("南昌，简称 “洪”或“昌”，古称豫章、洪都[1]  ，江西省省会，是中国最早的航空工业基地、重要的综合交通枢纽[2]  和光电产业基地[2]  ，世界级的光伏产业基地");
		data.add(
			"九江，简称 “浔”，是江西省下辖地级市，古称浔阳、柴桑、江州，是一座有着2200多年历史的江南文化名城。九江位于江西省最北部，赣、鄂、皖、湘四省交界处，号称“三江之口、七省通衢”与“天下眉目之地”，有“江西北大门”之称。九江是“三大茶市”和“四大米市”之一，是江南地区“的鱼米之乡”。地处长江、鄱阳湖、京九铁路三大经济开发带交叉点。");
		data.add("上饶，古称饶州、信州，为江西省下辖市（地级），位于江西省东北部，北纬27º48´～29º42´，东经116º13´～118º29´之间，属内陆区域。");
		data.add("抚州市，江西省下辖地级市，位于江西省东部。南北长约222千米，东西宽约169千米，总面积18816.92平方千米，占全省总面积的11.27%。抚州下辖2个区、9个县，总面积18817平方千米，2016年总人口400万，通用赣语。");
		data.add(
			"宜春，江西省地级市，位于江西省西北部，地处东经113°54′—116°27′，北纬27°33′—29°06′之间。东境与南昌市接界，东南与抚州市为邻，南陲与吉安市及新余市毗连，西南与萍乡市接壤，北与九江市相邻，西北与湖南省的长沙市、岳阳市交界。");
		data.add(
			"吉安为江西省下辖地级市，古称庐陵、吉州，元初取“吉泰民安”之意改称吉安。[1]  位于江西省中部，西接湖南省，揽罗霄山脉中段，赣江中游，据富饶的吉泰盆地，是江西建制最早的古郡之一，是赣文化发源地之一。吉安下辖2区1市10县。全市总面积25300平方千米，2016年人口530.4万。");
		data.add(
			"赣州，江西省省辖市，简称“虔”，别称“虔城”，也称“赣南”，位于江西省南部，是江西省的南大门，是江西省面积最大、人口最多的地级市。赣州地处中亚热带南缘属亚热带季风气候区，地形以山地、丘陵为主，总面积39379.64平方千米，占江西省总面积的23.6%，下辖3个市辖区、14个县、1个县级市。2016年末全市户籍人口为970.78万人，比上年末增加10.15万人。");
		data.add(
			"景德镇市，隶属于江西省，别名 “瓷都”，位于江西省东北部，西北与安徽省东至县交界，南与万年县为邻，西同鄱阳县接壤，东北倚安徽省祁门县，东南和婺源县毗连。介于东经116°57′—117°42′，北纬28°44′—29°56′之间，总面积5256平方千米。");
		data.add(
			"萍乡市，是江西省地级市，位于江西省西部，东与本省宜春市、南与吉安市、西与湖南省株洲市、北与湖南省长沙市接壤。地处东经113°35′～114°17′，北纬27°20′～28°0′之间。萍乡是江西的“西大门”，在赣西经济发展格局中处于中心位置，素有“湘赣通衡”、“吴楚咽喉”之称。因古代萍乡生有一种水面浮生植物萍草，是萍草之乡而得市名。");
		data.add(
			"新余市，为江西省地级市，位于江西省中部偏西，浙赣铁路西段，全境东西最长处101.8公里，南北最宽处65.2公里，东临樟树市、新干县，西接宜春市袁州区，南连吉安市青原区、安福县、峡江县，北毗上高县、高安市。新余是江西省的一个新兴工业城市，1960年设市，1963年撤市，1983年复市，工业化率达51.3%，城市化率达56.6%。");
		data.add("鹰潭市，为江西省地级市，“涟漪旋其中，雄鹰舞其上”而得市名，同时享有“道都”、“铜都”、“创客之城”等美誉。");
		return data;
	}


}
