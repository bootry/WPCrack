package uncleandroid.wpcrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.android.support.cardview.*;
import com.android.support.cardview.aj;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                ParamUtil.changeParam.imei = ParamUtil.getimei(MainActivity.this);
                ParamUtil.changeParam.imsi = ParamUtil.getImsiId(MainActivity.this);
                LogString.Log("imei:" + ParamUtil.changeParam.imei + " imsi:" + ParamUtil.changeParam.imsi);

                // 激活
                new NetRequest().a(MainActivity.this, ParamUtil.getActiveUrl(MainActivity.this), true);

                AppConnect_a.o(MainActivity.this);
                if(!cy.b(AppConnect_a.bp)) {
                    LogString.Log(AppConnect_a.bp);
                    new UserInfoRequest().b(MainActivity.this, "http://app.wapx.cn/action/user_info",  ParamUtil.changeParam.imei +"=" + AppConnect_a.bp);
                }


                // 获取插屏数据
                String result1 = new NetRequest().a(MainActivity.this, ParamUtil.getPop_ad(MainActivity.this), true);
                ArrayList<WPAdInfo>wpAdInfos1 = parseXml(result1);
                if (wpAdInfos1.size() > 0) {
                    new NetRequest().download(MainActivity.this, wpAdInfos1.get(0).getImage(), false);
//                    new NetRequest().download(MainActivity.this, wpAdInfos1.get(0).getDownUrl(), false);
                }

                String result2 = new NetRequest().a(MainActivity.this, ParamUtil.getPop_ad(MainActivity.this), true);
                final ArrayList<WPAdInfo>wpAdInfos2 = parseXml(result2);



                WPAdInfo clickWpAdInfo = null;
                if (wpAdInfos2.size() > 0) {
                    for (int i = 0; i < wpAdInfos2.size(); i++){
                        final int j = i;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                new NetRequest().download(MainActivity.this, wpAdInfos2.get(j).getImage(), false);
                            }
                        }).start();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                new NetRequest().download(MainActivity.this, wpAdInfos2.get(j).getDownUrl(), false);
                            }
                        }).start();

                    }
                    int num2 = wpAdInfos2.size();
                    int position2 = new Random().nextInt(num2);
                    clickWpAdInfo = wpAdInfos2.get(position2);
                } else if (wpAdInfos1.size() > 0){
                    for (int i = 1; i < wpAdInfos1.size(); i++){

                        final int j = i;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                new NetRequest().download(MainActivity.this, wpAdInfos2.get(j).getImage(), false);
                            }
                        }).start();

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                new NetRequest().download(MainActivity.this, wpAdInfos2.get(j).getDownUrl(), false);
                            }
                        }).start();
                    }
                    int num1 = wpAdInfos1.size();
                    int position1 = new Random().nextInt(num1);
                    clickWpAdInfo = wpAdInfos1.get(position1);
                } else {
                    return;
                }

                if (clickWpAdInfo == null || TextUtils.isEmpty(clickWpAdInfo.getAdPackage())
                        || TextUtils.isEmpty(clickWpAdInfo.getDownUrl())) {
                    return;
                }

                try {
                    Thread.sleep(15000 - new Random().nextInt(5000));
                }catch (Exception e) {

                }

                String downloadCode = new NetRequest().download(MainActivity.this,
                        ParamUtil.getDownload(MainActivity.this,clickWpAdInfo.getDownUrl()), false);

                if ("200".equals(downloadCode)){
                    // 下载成功
                    LogString.Log("触发安装");
                    try {
                        Thread.sleep(20000 - new Random().nextInt(5000));
                    }catch (Exception e) {
                        LogString.Log("异常1");
                    }
                    LogString.Log("安装");
                    // 安装
                    new NetRequest().a(MainActivity.this, ParamUtil.getInstall(MainActivity.this, clickWpAdInfo.getAdPackage()), false);
                } else {
                    LogString.Log("重试");
                    String downloadCode1 = new NetRequest().download(MainActivity.this,
                            ParamUtil.getDownload(MainActivity.this,clickWpAdInfo.getDownUrl()), false);
                    if ("200".equals(downloadCode1)) {
                        LogString.Log("触发安装");
                        try {
                            Thread.sleep(20000);
                        }catch (Exception e) {
                            LogString.Log("异常1");
                        }
                        LogString.Log("安装");
                        // 安装
                        new NetRequest().a(MainActivity.this, ParamUtil.getInstall(MainActivity.this, clickWpAdInfo.getAdPackage()), true);
                    }
                    return;
                }

            }
        }).start();



    }

    private ArrayList<WPAdInfo> parseXml(String data){
        ArrayList<WPAdInfo> persons = new ArrayList<WPAdInfo>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            LogString.Log(data);
            InputStream is = new ByteArrayInputStream(data.getBytes());
            Document dom = builder.parse(is);
            Element root = dom.getDocumentElement();
            NodeList items = root.getElementsByTagName("Ad");
            LogString.Log(items.getLength() + "");

            for (int i = 0; i < items.getLength(); i++) {
                WPAdInfo person = new WPAdInfo();

                //得到第一个person节点
                Element personNode = (Element) items.item(i);


                //获取person节点下的所有子节点(标签之间的空白节点和name/age元素)
                NodeList childsNodes = personNode.getChildNodes();

                for (int j = 0; j < childsNodes.getLength(); j++) {
                    Node node = (Node) childsNodes.item(j); //判断是否为元素类型

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        Element childNode = (Element) node;
                        if ("Id".equals(childNode.getNodeName())) {
                            //获取name元素下Text节点,然后从Text节点获取数据
                            person.setId(childNode.getFirstChild().getNodeValue());
                        } else if ("Title".equals(childNode.getNodeName())) {
                            person.setTitle(childNode.getFirstChild().getNodeValue());
                        }else if ("Image".equals(childNode.getNodeName())) {
                            person.setImage(childNode.getFirstChild().getNodeValue());
                        } else if ("ClickUrl".equals(childNode.getNodeName())) {
                            person.setClickUrl(childNode.getFirstChild().getNodeValue());
                        } else if ("Show_notice_url".equals(childNode.getNodeName())) {
                            person.setShow_notice_url(childNode.getFirstChild().getNodeValue());
                        }else if ("AdPackage".equals(childNode.getNodeName())) {
                            person.setAdPackage(childNode.getFirstChild().getNodeValue());
                        }else if ("DownUrl".equals(childNode.getNodeName())) {
                            person.setDownUrl(childNode.getFirstChild().getNodeValue());
                        }else if ("YuDownUrl".equals(childNode.getNodeName())) {
                            person.setYuDownUrl(childNode.getFirstChild().getNodeValue());
                        }
                    }
                }

                persons.add(person);
            }

        } catch (Exception e) {
            LogString.Log("E" + e.getMessage());
        }finally {
        }

        return persons;

    }
}
