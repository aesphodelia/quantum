package com.example.quantum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> itemsList = new ArrayList<>();
        HashMap<String, String> linksMap = new HashMap<>();

        linksMap.put("197001", "https://drive.google.com/file/d/1DHmJSg2thlzeJx0utcsf6Zdnnh0ufCmY/view?usp=sharing");
        linksMap.put("197002", "https://drive.google.com/file/d/1UYdOLTdu0PHQIyWNqmzy3tnHfENvakAd/view?usp=sharing");
        linksMap.put("197003", "https://drive.google.com/file/d/1Bxrm4MPs7jMHzTnvxtEHSYiFCI5m5ZVh/view?usp=sharing");
        linksMap.put("197004", "https://drive.google.com/file/d/1ktmQqBLl6UF-mEkcoA1Ec24MQt_rG7Yu/view?usp=sharing");
        linksMap.put("197005", "https://drive.google.com/file/d/11xqFilAG82BOdichLtio8S8hFx2Vfu6z/view?usp=sharing");
        linksMap.put("197006", "https://drive.google.com/file/d/1TxjxqKETuVsJ2HT5NQvfX_PzGupO0tvO/view?usp=sharing");
        linksMap.put("197007", "https://drive.google.com/file/d/1z38JKIAAEbFKRqClGRzIlQH9gh-Wg5rA/view?usp=sharing");
        linksMap.put("197008", "https://drive.google.com/file/d/1R0Ft-feVoi6agcJMQqhewAdqDb31cUqc/view?usp=sharing");
        linksMap.put("197009", "https://drive.google.com/file/d/1hYmcEDC0mdpJ5MSbSkeTbiuAWTXviqXV/view?usp=sharing");
        linksMap.put("197010", "https://drive.google.com/file/d/1qD-yE2ddkaUocnBMsqG3qXeZoHflQtjE/view?usp=sharing");
        linksMap.put("197011", "https://drive.google.com/file/d/1MJEMtJqWW3oe3wwc0_ILibK1vIJ4XPaL/view?usp=sharing");
        linksMap.put("197012", "https://drive.google.com/file/d/1OBWzsCDiIGonJTwEiqE3HCU-DO7ww-_4/view?usp=sharing");
        linksMap.put("197101", "https://drive.google.com/file/d/1iGQQMS_NwEZdvKsZUUIf6EIJJKImifPz/view?usp=sharing");
        linksMap.put("197102", "https://drive.google.com/file/d/1_gEij2uiuc2iX-5ta0dbzCWEjXzRbqST/view?usp=sharing");
        linksMap.put("197103", "https://drive.google.com/file/d/1uJD4GBZz2vmpF6Fb3KJJiajpmUKW5sZe/view?usp=sharing");
        linksMap.put("197104", "https://drive.google.com/file/d/11UScH9E8fe1JPvuZLhoOqDgdku3m9MhW/view?usp=sharing");
        linksMap.put("197105", "https://drive.google.com/file/d/1UYMjUsSo62ri7uBn3T-N0BHRvsqtoGHE/view?usp=sharing");
        linksMap.put("197106", "https://drive.google.com/file/d/1WmIprMxuwOiUa8uWtc6SuRrZgZKVXDic/view?usp=sharing");
        linksMap.put("197107", "https://drive.google.com/file/d/18CsKoKa_DTJPhelLCaQ7zXEuMyl60Pe5/view?usp=sharing");
        linksMap.put("197108", "https://drive.google.com/file/d/1JjAU-1SMitAgOtkZ59rDKtbSlWLsUkI7/view?usp=sharing");
        linksMap.put("197109", "https://drive.google.com/file/d/1wh2RuQPN9c4nx4vNdjZItNa707a03itu/view?usp=sharing");
        linksMap.put("197110", "https://drive.google.com/file/d/1FalC5u-KDvw3d5Gfao61_TmkVojUmsuM/view?usp=sharing");
        linksMap.put("197111", "https://drive.google.com/file/d/1Ys-UrN-X31fkrXp8tF-6fOzXds7zA6RI/view?usp=sharing");
        linksMap.put("197112", "https://drive.google.com/file/d/1JlqE1XPj99AaTjKTGmzWIT5KBph2ss8W/view?usp=sharing");

        linksMap.put("197201", "https://drive.google.com/file/d/1Ev-qXd2NdRwI0OHbFNwrnVJUsX4Gw-MR/view?usp=sharing");
        linksMap.put("197202", "https://drive.google.com/file/d/18uVqkfE59JMPWxiWNJivtcBlTZK53INm/view?usp=sharing");
        linksMap.put("197203", "https://drive.google.com/file/d/1xMAI75XAExDoh-JjBJZHFUcY_E6o-SJU/view?usp=sharing");
        linksMap.put("197204", "https://drive.google.com/file/d/1orFTdj3FLylJb2T_cU__BlAg04wffycj/view?usp=sharing");
        linksMap.put("197205", "https://drive.google.com/file/d/1cwrElyjFP8sQ7abIJD5KXi2e1yktDG27/view?usp=sharing");
        linksMap.put("197206", "https://drive.google.com/file/d/1WjtHz9Fv6ofMy1SCNDtxWkZsGkn1IrBd/view?usp=sharing");
        linksMap.put("197207", "https://drive.google.com/file/d/1enzoDUpxRE4ESjCD1McFGYz45tF1zoow/view?usp=sharing");
        linksMap.put("197208", "https://drive.google.com/file/d/1cLVOBzCZQ7Hexb5BFPCxc88hTIpsO_h0/view?usp=sharing");
        linksMap.put("197209", "https://drive.google.com/file/d/1Bus1zWCxcs6vx8-LzZAfJt8vx23wFpV9/view?usp=sharing");
        linksMap.put("197210", "https://drive.google.com/file/d/1lTn4P9yTgLvkSuqAXZgyi1FCXSAo9s9A/view?usp=sharing");
        linksMap.put("197211", "https://drive.google.com/file/d/1SjMc5-UWGgGP98qG-xXRU5o1_TSQqQ71/view?usp=sharing");
        linksMap.put("197212", "https://drive.google.com/file/d/1BPrgwPwMGBdmBNjWCUuUGOpeWqRIOY2F/view?usp=sharing");

        linksMap.put("197301", "https://drive.google.com/file/d/13ZN_OoOGxBbNaGxWIZyCC-dIzutf-MWt/view?usp=sharing");

        linksMap.put("197302", "https://drive.google.com/file/d/19NUb0KzlTV38g4injP2bG9a4hy3YQ-vZ/view?usp=sharing");

        linksMap.put("197303", "https://drive.google.com/file/d/1UhHdI_bPhh0QKwH_w48l0uBaLL1HBLTi/view?usp=sharing");

        linksMap.put("197304", "https://drive.google.com/file/d/1aWQePkugT6tOvtXtpH55u6Ako0mpvxfo/view?usp=sharing");

        linksMap.put("197305", "https://drive.google.com/file/d/1b4b6bo7BNBoodA3I1aKykllNfvb7S_Rm/view?usp=sharing");

        linksMap.put("197306", "https://drive.google.com/file/d/1U5HqDAQJhyXY_89ownlgV020Z9OmdhEo/view?usp=sharing");

        linksMap.put("197307", "https://drive.google.com/file/d/1UigVMQDUSX0tbvHav5s98xs70mwkpOwF/view?usp=sharing");

        linksMap.put("197308", "https://drive.google.com/file/d/1xFJKJt5b3m6raRQEjt6l_pqP9q3CWLbS/view?usp=sharing");

        linksMap.put("197309", "https://drive.google.com/file/d/1I1kGuMepfzZZWO7ZVMnU3O-Gt2n3LBSo/view?usp=sharing");

        linksMap.put("197310", "https://drive.google.com/file/d/1OsiZel-0ZhYbNafgi5-OAJshBrirQFxc/view?usp=sharing");

        linksMap.put("197311", "https://drive.google.com/file/d/1d6IpHczdFLy9rb_x7GdcSIWqiNHCnbJZ/view?usp=sharing");

        linksMap.put("197312", "https://drive.google.com/file/d/1pTr5RM9U1OpXzyV_MAndllZJB0bnja0-/view?usp=sharing");

        linksMap.put("197401", "https://drive.google.com/file/d/1QFdEscxI0xUqQjBIuIDfsZt5JQ0TE6JI/view?usp=sharing");

        linksMap.put("197402", "https://drive.google.com/file/d/1LeWQ8RCI0t6BnJyin4WJw4_msvuhEqS_/view?usp=sharing");

        linksMap.put("197403", "https://drive.google.com/file/d/1Xrz5o9S4wxKchaAhQOVyhR1hikkbmpkU/view?usp=sharing");

        linksMap.put("197404", "https://drive.google.com/file/d/10b5FsZ1EvIPH4UOk8TnYPTRN0QUn2LrJ/view?usp=sharing");

        linksMap.put("197405", "https://drive.google.com/file/d/19V8OsUvU7vNeKX3oLISHDbOrbbk4rK0l/view?usp=sharing");

        linksMap.put("197406", "https://drive.google.com/file/d/1eJ_5or8aV425rWzeoxGhQxPTmc5PDRh6/view?usp=sharing");

        linksMap.put("197407", "https://drive.google.com/file/d/1qN0Sk3uwebz03Fpd9awKcLIBFgWV-N8l/view?usp=sharing");

        linksMap.put("197408", "https://drive.google.com/file/d/11WF_9Gq6jTmOnxluq59BKlSzn-s3_gUI/view?usp=sharing");

        linksMap.put("197409", "https://drive.google.com/file/d/1g79XsMurdi5U1HfrchybV4cMkPwVM90O/view?usp=sharing");

        linksMap.put("197410", "https://drive.google.com/file/d/1Jn0_CXJmT7XNg5pG7qJ4VD8BGinuC7Gv/view?usp=sharing");

        linksMap.put("197411", "https://drive.google.com/file/d/1a6nseQLS2ZDhMWihELRiHk9YjRCPf9iv/view?usp=sharing");

        linksMap.put("197412", "https://drive.google.com/file/d/1EtTkzj2IYZyrW4PjnQql_9me44-maFa5/view?usp=sharing");

        linksMap.put("197501", "https://drive.google.com/file/d/1Fr_qjf57-Urr_LLvynrvMRGXSNduukJZ/view?usp=sharing");

        linksMap.put("197502", "https://drive.google.com/file/d/1XulGXmq1qyYRZxzk25LJ7SpPRYMqU2hN/view?usp=sharing");

        linksMap.put("197503", "https://drive.google.com/file/d/1_bnWLUTaQAltPx5eMe8sKX39aU9kqdkg/view?usp=sharing");

        linksMap.put("197504", "https://drive.google.com/file/d/1cDMSdvnzbUo38hOXfdUy4k8rB3-Hd9Gt/view?usp=sharing");

        linksMap.put("197505", "https://drive.google.com/file/d/1rvB22M811JlxT-1-PWnK_Cuk394SpLaW/view?usp=sharing");

        linksMap.put("197506", "https://drive.google.com/file/d/1EvT7XGZS8i5DKXxM-Z77P0b-jWEOqbFE/view?usp=sharing");

        linksMap.put("197507", "https://drive.google.com/file/d/1XQ4HRMK5vYjBJKJX_Xb3RYvdYBeQcfSS/view?usp=sharing");

        linksMap.put("197508", "https://drive.google.com/file/d/1oghksc-CVHsxxfFEuQB1BzpOnthkpx26/view?usp=sharing");

        linksMap.put("197509", "https://drive.google.com/file/d/1NYOinv0KMOxe54FAHV3CHZL8FCZMdU0e/view?usp=sharing");

        linksMap.put("197510", "https://drive.google.com/file/d/1G7qSHNgxoawvn_fWNv7tJVmcjdQucE9K/view?usp=sharing");

        linksMap.put("197511", "https://drive.google.com/file/d/1OFAEeHA9VwY6MqstgFvKtz4n2OJKU4FH/view?usp=sharing");

        linksMap.put("197512", "https://drive.google.com/file/d/1N0x3V9Mdr-oZyP6l4hG0Aiiy7nXP58Ce/view?usp=sharing");

        linksMap.put("197601", "https://drive.google.com/file/d/1S0E70xFhmh59hCqXQ7060nMnpf478Pfm/view?usp=sharing");

        linksMap.put("197602", "https://drive.google.com/file/d/1Aa10pRYMgOR7nU25YWzDhH8Vq8UCc9k1/view?usp=sharing");

        linksMap.put("197603", "https://drive.google.com/file/d/1rP9xAvKnFG1rmHIm-H1M2-DQ3BHAmjFH/view?usp=sharing");

        linksMap.put("197604", "https://drive.google.com/file/d/13sW4I3Rw66kzX_rPqj8M8AGwEGQWHORD/view?usp=sharing");

        linksMap.put("197605", "https://drive.google.com/file/d/1er9VBMWeFCIcLgQRZPeuhjyO7gTKwFa4/view?usp=sharing");

        linksMap.put("197606", "https://drive.google.com/file/d/1XEJmfio7i2DQVCCpY6hTjkLYdoWoSMar/view?usp=sharing");

        linksMap.put("197607", "https://drive.google.com/file/d/1vdDpgAmk_4yqAQ5-c6k_1A6r4Gxz8-Gi/view?usp=sharing");

        linksMap.put("197608", "https://drive.google.com/file/d/1mAgfd7s3L5v6uCblmZRoiZO3aNBPNzAG/view?usp=sharing");

        linksMap.put("197609", "https://drive.google.com/file/d/172cR69zJ5mNnxrPBuiSVdxjrEaeP9PgP/view?usp=sharing");

        linksMap.put("197610", "https://drive.google.com/file/d/1C4lN9qVOqpyldsaAquqIW7kLOeqTRUDd/view?usp=sharing");

        linksMap.put("197611", "https://drive.google.com/file/d/1KVXEJgNXXOrPAhD-r894kYssMfT-Husu/view?usp=sharing");

        linksMap.put("197612", "https://drive.google.com/file/d/1uAdmKYMoOwZ1wHzFJtu22YBUfVwtTWHd/view?usp=sharing");

        linksMap.put("197701", "https://drive.google.com/file/d/1x8s7SOtdQB3Z4wHUCySYdf51k0tX6arI/view?usp=sharing");

        linksMap.put("197702", "https://drive.google.com/file/d/1BQBc3NkZHFTtQ2IumVwi5IyJLTpezvvm/view?usp=sharing");

        linksMap.put("197703", "https://drive.google.com/file/d/1rewqX52M5RCC2DxJR0PAk_CjqX111xFv/view?usp=sharing");

        linksMap.put("197704", "https://drive.google.com/file/d/14d_QLb7cPcXm8SMhnJKU59kyOdDY_OfN/view?usp=sharing");

        linksMap.put("197705", "https://drive.google.com/file/d/1QVefSxpRpyvKMWygtpF5KCRMnwH4dYhv/view?usp=sharing");

        linksMap.put("197706", "https://drive.google.com/file/d/1f1FPN448sm0AJHvlLjIl7ILs2a5cB3CI/view?usp=sharing");

        linksMap.put("197707", "https://drive.google.com/file/d/1l3TQjHhd-Gok7_Yr-NKtS4JHLmAdeft8/view?usp=sharing");

        linksMap.put("197708", "https://drive.google.com/file/d/1faTysoiZk6sD-84Z6vav4TuWZDmrrdyU/view?usp=sharing");

        linksMap.put("197709", "https://drive.google.com/file/d/15jq2M4JWx3lWZlkXygU54f9ad7sSdTKh/view?usp=sharing");

        linksMap.put("197710", "https://drive.google.com/file/d/1yi2mRW44faPaN16Hskai1uU7vJM1ON1j/view?usp=sharing");

        linksMap.put("197711", "https://drive.google.com/file/d/1J40hf_XsvtIQRmJO_SE_v5ulKOf1PyRU/view?usp=sharing");

        linksMap.put("197712", "https://drive.google.com/file/d/1-KMG_a5VoMJaPKjPJfxNgSJhsx1M077Y/view?usp=sharing");

        linksMap.put("197801", "https://drive.google.com/file/d/1PYcGBdWewgfqwYXXBl6gf5dtOXtG05mM/view?usp=sharing");

        linksMap.put("197802", "https://drive.google.com/file/d/183ImVK0Sif8Q4HGcHLmf0IO_Yzr-4c5p/view?usp=sharing");

        linksMap.put("197803", "https://drive.google.com/file/d/1SX5-z847l9VwRZX8h3R0yxEoz9W-lrq8/view?usp=sharing");

        linksMap.put("197804", "https://drive.google.com/file/d/1NSgrFiS_Au7m3vWUZ2qKRM6OgS2tPdyN/view?usp=sharing");

        linksMap.put("197805", "https://drive.google.com/file/d/1H1ZWG8VaHGyC7N0DU23MV-iYbCd7E1cH/view?usp=sharing");

        linksMap.put("197806", "https://drive.google.com/file/d/1XbjmdTi1xTX_XfG7thCpyh0U6t2CXsdv/view?usp=sharing");

        linksMap.put("197807", "https://drive.google.com/file/d/1S0mMyCQSkIMkLCHF6z6boq_A2plXWsPi/view?usp=sharing");

        linksMap.put("197808", "https://drive.google.com/file/d/11VHWsiedpw0p-XkzXcKp1zUkm-Qm841O/view?usp=sharing");

        linksMap.put("197809", "https://drive.google.com/file/d/1zMY-vdlefih5SlpZSk_ZtAmMtmgWIMyE/view?usp=sharing");

        linksMap.put("197810", "https://drive.google.com/file/d/16NM0UIFpSJrnZj10QKGoMHo5pTZLNyZ7/view?usp=sharing");

        linksMap.put("197811", "https://drive.google.com/file/d/1JFaLl9EY7Z8qD96LInlRP05vhaKQXSsc/view?usp=sharing");

        linksMap.put("197812", "https://drive.google.com/file/d/1U-lqUtbFGjX9ttfgJ2V3Td0c1dV5DScw/view?usp=sharing");

        linksMap.put("197901", "https://drive.google.com/file/d/10plPA0th7_lU--J7maDQIU3oWr3h3_hW/view?usp=sharing");

        linksMap.put("197902", "https://drive.google.com/file/d/1AkSyyFgowEA_ful9o8H_BcGfAq8iRGlp/view?usp=sharing");

        linksMap.put("197903", "https://drive.google.com/file/d/1eCv3HgtbiEn9BKGRX_bLz5NVZCHTwuLZ/view?usp=sharing");

        linksMap.put("197904", "https://drive.google.com/file/d/1XbfS9hPW8hLD1jv_60yER3lYMXQcK258/view?usp=sharing");

        linksMap.put("197905", "https://drive.google.com/file/d/1DRnFmcpCRoUC7ToLfW2kFV1Pr7_TVFzP/view?usp=sharing");

        linksMap.put("197906", "https://drive.google.com/file/d/1FsVGVSG8vKWkNfqykuTuvAOZDstPhSZY/view?usp=sharing");

        linksMap.put("197907", "https://drive.google.com/file/d/1KfACiL88HfENVbD2OChdVyttZppRPHGQ/view?usp=sharing");

        linksMap.put("197908", "https://drive.google.com/file/d/1PN-7xX4jDIDE0nduLaoSPt2XP2PEFHCb/view?usp=sharing");

        linksMap.put("197909", "https://drive.google.com/file/d/1_nvhQUIIUPy2uzmios9SlwKIyslBOL9y/view?usp=sharing");

        linksMap.put("197910", "https://drive.google.com/file/d/1qCbIgOOWguGKehjWPslxDXkKiPd5qbwW/view?usp=sharing");

        linksMap.put("197911", "https://drive.google.com/file/d/1S1KVsn4n45vRaQ7CMNoOxs7oCKfUkefT/view?usp=sharing");

        linksMap.put("197912", "https://drive.google.com/file/d/1OztUIBW2oARfAv6fqAGWO40mO7dhFmdx/view?usp=sharing");

        linksMap.put("198001", "https://drive.google.com/file/d/1MPwE2RQ2K8oGIaWwAvwIJTasodswdvUW/view?usp=sharing");

        linksMap.put("198002", "https://drive.google.com/file/d/1KcbARzyPMJR0zkriBcEGsl1AsZm0HWal/view?usp=sharing");

        linksMap.put("198003", "https://drive.google.com/file/d/1jkaBzBhxEwKWKO7KkZznPLv89KiYjKJH/view?usp=sharing");

        linksMap.put("198004", "https://drive.google.com/file/d/1h-R1gjz6l5ZigR6OUYoN86csZJLAd02_/view?usp=sharing");

        linksMap.put("198005", "https://drive.google.com/file/d/1beK9UV5Yk2cN2GhP1TdJdR-WcOx8VgRs/view?usp=sharing");

        linksMap.put("198006", "https://drive.google.com/file/d/18lOZFlpmPVIvUfq4g7vW_p_vWqwbKC16/view?usp=sharing");

        linksMap.put("198007", "https://drive.google.com/file/d/1ecdzmlOTeWBvTSlO-6jJ590rcEfOdwzc/view?usp=sharing");

        linksMap.put("198008", "https://drive.google.com/file/d/1IM_f8bUS45Ny18JJeHxkP2UKXAFLZK2X/view?usp=sharing");

        linksMap.put("198009", "https://drive.google.com/file/d/1kpNM1Ni2IRnXQOx-DPmLwPmK4ejB09yM/view?usp=sharing");

        linksMap.put("198010", "https://drive.google.com/file/d/107sknjccnvdRL0sxaiOK_q2xOk3CdunR/view?usp=sharing");

        linksMap.put("198011", "https://drive.google.com/file/d/1761RsJFBIn2JOpknFDSwjUHAF0zVsTyN/view?usp=sharing");

        linksMap.put("198012", "https://drive.google.com/file/d/1JI513RR2Gx71qINu8OoTLhlLnDQGhjrU/view?usp=sharing");

        linksMap.put("198101", "https://drive.google.com/file/d/1GDrTyvBbRfPtV9DOjE3h68_uMw6-M2Pb/view?usp=sharing");

        linksMap.put("198102", "https://drive.google.com/file/d/1U3UPlBrryyvVFTAXwFM2-897P2KpGegH/view?usp=sharing");

        linksMap.put("198103", "https://drive.google.com/file/d/18oDIPwsjc8aD8FkO_px_LDKqO7RO-aeA/view?usp=sharing");

        linksMap.put("198104", "https://drive.google.com/file/d/1UIKybBvW-zrfTHtICfzzGY0P1BH_rQst/view?usp=sharing");

        linksMap.put("198105", "https://drive.google.com/file/d/1HAUPXsK_BQ6xpbWAZFAyTaRBEoJkxJcC/view?usp=sharing");

        linksMap.put("198106", "https://drive.google.com/file/d/1P7ZqFOWe9g8krXVKqorSFVJllNrLa98Z/view?usp=sharing");

        linksMap.put("198107", "https://drive.google.com/file/d/1INN1oWb68T66kaK3JSNN_kFpR_2QP8AC/view?usp=sharing");

        linksMap.put("198108", "https://drive.google.com/file/d/1qYfPy4mUvjz2wtjoAktkyXSC_kYrNEwg/view?usp=sharing");

        linksMap.put("198109", "https://drive.google.com/file/d/1D1tPjMbBSeO4HARNRdxdvIUWYUi4My6J/view?usp=sharing");

        linksMap.put("198110", "https://drive.google.com/file/d/1MkYihnvzyWLHHdMRRDIoDik6i2y5nxZP/view?usp=sharing");

        linksMap.put("198111", "https://drive.google.com/file/d/1J5btcP6bJPIw82krZ-imPSaWu0fCAYKX/view?usp=sharing");

        linksMap.put("198112", "https://drive.google.com/file/d/1xveXa_0VshEARnMoygqGwug9hDeS5X8_/view?usp=sharing");

        linksMap.put("198201", "https://drive.google.com/file/d/1aBVF8XkmHn11xdj4T1KqF0hQClNsQk_b/view?usp=sharing");

        linksMap.put("198202", "https://drive.google.com/file/d/1typUdnRT8VOMqcVaEz6RoTW9Trn42Mwy/view?usp=sharing");

        linksMap.put("198203", "https://drive.google.com/file/d/1a1XEHAXbNXB4EQgZaN5iPVv0utpVSMAU/view?usp=sharing");

        linksMap.put("198204", "https://drive.google.com/file/d/1p6lJSF0_bJwuQ4wN9lIwfqDSeDldxjwf/view?usp=sharing");

        linksMap.put("198205", "https://drive.google.com/file/d/1QU3pFbMi0-_L8znkNUSCPJWF6ttZfvLf/view?usp=sharing");

        linksMap.put("198206", "https://drive.google.com/file/d/1Ac5VgmN-ED4abUZs0Ryj-r6Ckz-BjzNV/view?usp=sharing");

        linksMap.put("198207", "https://drive.google.com/file/d/1C7CakzJbzYcDpPkonzCZTyx4Vgr3z0rd/view?usp=sharing");

        linksMap.put("198208", "https://drive.google.com/file/d/1T33oIhnpBrIWB5sECzzoYYB1T5i3ICeD/view?usp=sharing");

        linksMap.put("198209", "https://drive.google.com/file/d/1SQMhZViObXxov9YB4YhG8kNIa--XkN5I/view?usp=sharing");

        linksMap.put("198210", "https://drive.google.com/file/d/1rSXy8fdn2JZ3oUqpZAZhw4WTclxWBgQH/view?usp=sharing");

        linksMap.put("198211", "https://drive.google.com/file/d/1ah3Mn1LwZJnCOA8h2sxbswV-YWIBSihV/view?usp=sharing");

        linksMap.put("198212", "https://drive.google.com/file/d/1ZSdVtnWudbWI5AC-XGkBSByLQIPBxLGW/view?usp=sharing");

        linksMap.put("198301", "https://drive.google.com/file/d/1zRF_4Ux9YO85C7xtR3qRChtoiLnA6tbz/view?usp=sharing");

        linksMap.put("198302", "https://drive.google.com/file/d/1TmAwGuQbEjM-yEYgxpv8_qrlhD9J2CHF/view?usp=sharing");

        linksMap.put("198303", "https://drive.google.com/file/d/1OG23h9v222v4zhRoYi2I47Kdq2iAqd9s/view?usp=sharing");

        linksMap.put("198304", "https://drive.google.com/file/d/187dKg-D0CqgS5cNetMF9lWbhGaClJj3c/view?usp=sharing");

        linksMap.put("198305", "https://drive.google.com/file/d/1vrIx0LaEmOYpJSQ9XpSbZwhneobfUhOf/view?usp=sharing");

        linksMap.put("198306", "https://drive.google.com/file/d/1IzAV8JOd6M0rGU-7JsHPURid0Ip0Gxn-/view?usp=sharing");

        linksMap.put("198307", "https://drive.google.com/file/d/1R5LRXKg_-XRfSZxMktreR1sYbFESpO-i/view?usp=sharing");

        linksMap.put("198308", "https://drive.google.com/file/d/11mg9_DrwaSYZs5H-HpUSvK712bbNxsjs/view?usp=sharing");

        linksMap.put("198309", "https://drive.google.com/file/d/11XTfHc6LgdwgJUL4HDgZVK-Sn8DkTaDd/view?usp=sharing");

        linksMap.put("198310", "https://drive.google.com/file/d/1JvbmoUqkQei26otiuNhWTmnvSvwZVlaj/view?usp=sharing");

        linksMap.put("198311", "https://drive.google.com/file/d/1_yYofeVNPMjLrQXJg2H6PJtxqXyT1bpv/view?usp=sharing");

        linksMap.put("198312", "https://drive.google.com/file/d/1_isevWwMEVcq5cA4hoU1MGnCLwCgaJuE/view?usp=sharing");

        linksMap.put("198401", "https://drive.google.com/file/d/1FBjD3FNAnidZgeBnaSKGKcqgXZMbN9F-/view?usp=sharing");

        linksMap.put("198402", "https://drive.google.com/file/d/1__xrEGvZMJ5GYrk7oWnB7CU7DmTM6ZEH/view?usp=sharing");

        linksMap.put("198403", "https://drive.google.com/file/d/1DoCnPV_znmRbuIh4uDD9pTUf6XfXqoj0/view?usp=sharing");

        linksMap.put("198404", "https://drive.google.com/file/d/1IQ1udjrHa0uMuGuV5UPxV_oWzVylf-HM/view?usp=sharing");

        linksMap.put("198405", "https://drive.google.com/file/d/1BJnpQ9dr5gg1t740kBim49p9fqi4uB5U/view?usp=sharing");

        linksMap.put("198406", "https://drive.google.com/file/d/1wgz2iBcopWPWTV8fMMuaLBfbtAMLuyFJ/view?usp=sharing");

        linksMap.put("198407", "https://drive.google.com/file/d/11Bo3t1B0DK-Q2ENKx3MsYhcnDJM6XcGb/view?usp=sharing");

        linksMap.put("198408", "https://drive.google.com/file/d/1S9eAzrg12XvADTeo2RCWQAs_JRef3z8i/view?usp=sharing");

        linksMap.put("198409", "https://drive.google.com/file/d/1LA6dWE2cc_inoq9hqTh7Q6nK6Gp08wtI/view?usp=sharing");

        linksMap.put("198410", "https://drive.google.com/file/d/1saOz0EsTowBUsr9NgrZ2uckDLAAU4zTp/view?usp=sharing");

        linksMap.put("198411", "https://drive.google.com/file/d/1MYpVsYb3w347SGofiypSZ9eHGFRFjWQ0/view?usp=sharing");

        linksMap.put("198412", "https://drive.google.com/file/d/1cGIjgMbjJTDv6pN3Ax51moqqQoMR1z-a/view?usp=sharing");

        linksMap.put("198501", "https://drive.google.com/file/d/1spv0y0IN_pjNkn6c91avq76Kc3yjH4Um/view?usp=sharing");

        linksMap.put("198502", "https://drive.google.com/file/d/1Qcr1x3NsQyqnBaKW2Zy9IXPwHBlzXSj-/view?usp=sharing");

        linksMap.put("198503", "https://drive.google.com/file/d/1hnJ6GhKqJcuy8oK-IKJanF-YGOmv-5jw/view?usp=sharing");

        linksMap.put("198504", "https://drive.google.com/file/d/1Q4QIaXiFXXmQ68iMSQVD5MTgH_wVXy__/view?usp=sharing");

        linksMap.put("198505", "https://drive.google.com/file/d/1GZLhDPgOCjqOrLE1wHQdFldMUF-pgA7d/view?usp=sharing");

        linksMap.put("198506", "https://drive.google.com/file/d/12B3VPJPKCUk47dXxmvW3Jm54WBPBRVIr/view?usp=sharing");

        linksMap.put("198507", "https://drive.google.com/file/d/1MbnMqUcqt9ZsBvKfDMJqiKKUW_qXEM04/view?usp=sharing");

        linksMap.put("198508", "https://drive.google.com/file/d/1KL6U_vUm_ED8bXDD953GSVmtKZJ36ONx/view?usp=sharing");

        linksMap.put("198509", "https://drive.google.com/file/d/1fIezGYYtl4smRaU57UC9pI83fYneKVrJ/view?usp=sharing");

        linksMap.put("198510", "https://drive.google.com/file/d/1Ls_Ai93j3NVlpQ0g3Pkivo7DGZC5m_8S/view?usp=sharing");

        linksMap.put("198511", "https://drive.google.com/file/d/1cvEvTlX55bjHL-viPPyGWb4y8Wjy3JGx/view?usp=sharing");

        linksMap.put("198512", "https://drive.google.com/file/d/14lE9y5kjBlYHb8JfYtxeNuknGZs9sy5E/view?usp=sharing");

        linksMap.put("198601", "https://drive.google.com/file/d/1ANynFByXsjWIyfh34zIsSKDY6x0Ywjpx/view?usp=sharing");

        linksMap.put("198602", "https://drive.google.com/file/d/1WcL8Iv7pJ2mTewoSNo9tdfpFt2_jHvgM/view?usp=sharing");

        linksMap.put("198603", "https://drive.google.com/file/d/1alFwlC41HN48mTemM_PUxDtJBRBxKk6L/view?usp=sharing");

        linksMap.put("198604", "https://drive.google.com/file/d/1vaofwyksAWKMCv7rSl_p35lY1GWtTTmR/view?usp=sharing");

        linksMap.put("198605", "https://drive.google.com/file/d/1xsFL6Tedq_oyGWvikyKd7GfwCl3Euf8y/view?usp=sharing");

        linksMap.put("198606", "https://drive.google.com/file/d/1Sg4Ax1YpJOA0NQ73t8ux0Ln-5wJG2UWO/view?usp=sharing");

        linksMap.put("198607", "https://drive.google.com/file/d/1Or38Cp_c1uU8WB9QR2AlkM28xRhL2WNR/view?usp=sharing");

        linksMap.put("198608", "https://drive.google.com/file/d/1In3I4AdpiGJy9TkxUTVFwQ_Xz1cduaCv/view?usp=sharing");

        linksMap.put("198609", "https://drive.google.com/file/d/1qDwvaQoikntdYl5Dgax_ZMs_IyiFjbCT/view?usp=sharing");

        linksMap.put("198610", "https://drive.google.com/file/d/1v_420QGG8g_veCH5RyduM4aaJIMHL76H/view?usp=sharing");

        linksMap.put("198611", "https://drive.google.com/file/d/1qRlDVwHjrkPI_p3XuxT51X7Pe_aIjUR3/view?usp=sharing");

        linksMap.put("198612", "https://drive.google.com/file/d/1Ig9gzksx1o0dXjy9D05bPmUPvNGIkeXM/view?usp=sharing");

        linksMap.put("198701", "https://drive.google.com/file/d/1hlfLVWGp6gaYezxfllKESZ3G-F7LtDDV/view?usp=sharing");

        linksMap.put("198702", "https://drive.google.com/file/d/1ZpKr1WCyat0ASdQpFsYmwPPBeWnm14CS/view?usp=sharing");

        linksMap.put("198703", "https://drive.google.com/file/d/1cGfuYRKY5-BKv-V8apPFpcnopwffwejs/view?usp=sharing");

        linksMap.put("198704", "https://drive.google.com/file/d/13VZU8G2wDH4dwtAtSvfQ-wsuUTIbfu6y/view?usp=sharing");

        linksMap.put("198705", "https://drive.google.com/file/d/1BRm_6BulTwrIcSbJkOza-t2zYLmKhJrb/view?usp=sharing");

        linksMap.put("198706", "https://drive.google.com/file/d/1XlCroDshbWJc-VAapW99BJroWE5UHxT5/view?usp=sharing");

        linksMap.put("198707", "https://drive.google.com/file/d/1eEDajpcUJLyVZV0pGLDDC7vGde5jNM5Y/view?usp=sharing");

        linksMap.put("198708", "https://drive.google.com/file/d/1C-wEfZ3tDrD0MONXEI2_gp9Cs0fe9BnD/view?usp=sharing");

        linksMap.put("198709", "https://drive.google.com/file/d/1lq-2yKx4VyhkF5Lrn_pq3I-BB8iet-UY/view?usp=sharing");

        linksMap.put("198710", "https://drive.google.com/file/d/1qtGPekkLV7SQoUyjh2dLidk6c7c45HXB/view?usp=sharing");

        linksMap.put("198711", "https://drive.google.com/file/d/1JSb83JnBaDL3Gsqk0SEjaI5sqpTINBvi/view?usp=sharing");

        linksMap.put("198712", "https://drive.google.com/file/d/14EiMiQESvIGyce__OMaC4n0dk3WhOKWS/view?usp=sharing");

        linksMap.put("198901", "https://drive.google.com/file/d/1y7I0oa0sq6tBXSTnI6--VNDQOuT0AHR1/view?usp=sharing");

        linksMap.put("198902", "https://drive.google.com/file/d/1_4l3LEBoYYzyFB9hExtNUIZ9xhFQ4PN0/view?usp=sharing");

        linksMap.put("198903", "https://drive.google.com/file/d/1uaWy5hIN4DN0v_rHVgG19RyDHO0Of9E-/view?usp=sharing");

        linksMap.put("198904", "https://drive.google.com/file/d/1k5XCLYs5eqNbi74jS6smKAjBzlVqIBMu/view?usp=sharing");

        linksMap.put("198905", "https://drive.google.com/file/d/1bats3FXk1BP_x6qZkjKH_teXHr6lF5BE/view?usp=sharing");

        linksMap.put("198906", "https://drive.google.com/file/d/1_VYny4GOzhgp4AVu4kUuWQC8M-syRPhK/view?usp=sharing");

        linksMap.put("198907", "https://drive.google.com/file/d/1ndPhfKl-17dy-cYnBz4h-ZJ76iy-vqOj/view?usp=sharing");

        linksMap.put("198908", "https://drive.google.com/file/d/1CSGgDwq52lQ6RG_2k4cBhYdXeAtcgMsI/view?usp=sharing");

        linksMap.put("198909", "https://drive.google.com/file/d/17FqqmEHTE2aena1vPRrTzc9rKBKOF0Gr/view?usp=sharing");

        linksMap.put("198910", "https://drive.google.com/file/d/176lIWeXIAt0dBuTLnbG5uaagkV5Q0y3p/view?usp=sharing");

        linksMap.put("198911", "https://drive.google.com/file/d/1IjESfLDRJ18VTp4rFuV_p4nHKl9lyw_C/view?usp=sharing");

        linksMap.put("198912", "https://drive.google.com/file/d/1OwB-UJo1PgXdpGb8gLVuEkBjIYe7x17m/view?usp=sharing");

        linksMap.put("199001", "https://drive.google.com/file/d/1iJhbJ23wGOb0scCNELUb7vnj7hB8wHq7/view?usp=sharing");

        linksMap.put("199002", "https://drive.google.com/file/d/1HwvcGEDLoyPnUydwnGaBHc3n2EeHqrcZ/view?usp=sharing");

        linksMap.put("199003", "https://drive.google.com/file/d/1QUqBx6Gtt8VgvdxeUgyl5G-13vs7HifX/view?usp=sharing");

        linksMap.put("199004", "https://drive.google.com/file/d/1AYxPFLA9l3fu0gOy4IG73-LgqTqkKFYs/view?usp=sharing");

        linksMap.put("199005", "https://drive.google.com/file/d/1Ned3tvuXPHS0wyC1vPz8p335Y0PAaY1q/view?usp=sharing");

        linksMap.put("199006", "https://drive.google.com/file/d/1xpdgS9jFDx8BSLnvcoirwFu7J8btyq16/view?usp=sharing");

        linksMap.put("199007", "https://drive.google.com/file/d/1EG4TMfb-K1i4_sBpJDPguV-Z72y49OSX/view?usp=sharing");

        linksMap.put("199008", "https://drive.google.com/file/d/1jBUMtLITIA7SxEaT-vwKXAyShvw1KrhM/view?usp=sharing");

        linksMap.put("199009", "https://drive.google.com/file/d/180-EaQpfIOUH98Mp7WjMgViZTnN7PP2s/view?usp=sharing");

        linksMap.put("199010", "https://drive.google.com/file/d/1Zg2kwmRNXNxI401szS5S84oTNSK58ofp/view?usp=sharing");

        linksMap.put("199011", "https://drive.google.com/file/d/1JL5ecGohgfXqoKuqs3GDL-l1aGFYlmUK/view?usp=sharing");

        linksMap.put("199012", "https://drive.google.com/file/d/1b5ukWD-t0hn6eSwsaRIybNBIkVjU5jfS/view?usp=sharing");

        linksMap.put("199101", "https://drive.google.com/file/d/1A_iASCRGgUupnSb7scjGzBrsI1MH3CTt/view?usp=sharing");

        linksMap.put("199102", "https://drive.google.com/file/d/1o77l4GAoVa4UjkiSE3hTBZ0IaY2UjGWt/view?usp=sharing");

        linksMap.put("199103", "https://drive.google.com/file/d/1IM7YmNRTxs6eG1qjqw2HZN23RBb16ENh/view?usp=sharing");

        linksMap.put("199104", "https://drive.google.com/file/d/1SXvknkdogCUKgHlqUnK0kpeQLziH-76s/view?usp=sharing");

        linksMap.put("199105", "https://drive.google.com/file/d/1rvgf1wbes-NRn5tbudCJddLHFq3j74mc/view?usp=sharing");

        linksMap.put("199106", "https://drive.google.com/file/d/1DcZZOE69JrPwlobTyJ7Fj7WTYg8Oi7tu/view?usp=sharing");

        linksMap.put("199107", "https://drive.google.com/file/d/1dv_SH6NB8FCTPcrYNUyzNvHhe1eVsABh/view?usp=sharing");

        linksMap.put("199108", "https://drive.google.com/file/d/1K7LM8A3mBi3rMe31xivr4pwsy1M9L-Ek/view?usp=sharing");

        linksMap.put("199109", "https://drive.google.com/file/d/1-R62VHngsRxXkd2n2AkxUwLev6CvgmGw/view?usp=sharing");

        linksMap.put("199110", "https://drive.google.com/file/d/1TEVN0Uyrmyjw0L3wx88yoax5JxvsDZHN/view?usp=sharing");

        linksMap.put("199111", "https://drive.google.com/file/d/1l0xUt3TL8KEhAcLO-U4yAjOD0QZsxpil/view?usp=sharing");

        linksMap.put("199112", "https://drive.google.com/file/d/1orFWqIK0LAmPDz9l2rhL635WTKd7HKAu/view?usp=sharing");

        linksMap.put("199201", "https://drive.google.com/file/d/1hVamitZyosM2O7wYzS3E45VOcK6GnBAP/view?usp=sharing");

        linksMap.put("199202", "https://drive.google.com/file/d/1AC7qMjQswCW8V5uRJBECEGeYdgzdn_xl/view?usp=sharing");

        linksMap.put("199203", "https://drive.google.com/file/d/11hnd6xnsvUZlr13LLrkSSb5i1XeCMqIX/view?usp=sharing");

        linksMap.put("199204", "https://drive.google.com/file/d/1p8hk2N26E5W4HQ4TBUE8h5YUPMkjKrTG/view?usp=sharing");

        linksMap.put("199205", "https://drive.google.com/file/d/1FcWzlxgeB6g5qmtcck1hI-A7Ca4FTyDm/view?usp=sharing");

        linksMap.put("199206", "https://drive.google.com/file/d/1ODLKtJ9QAqzrcJtiWHwsU4T49jGWi0a9/view?usp=sharing");

        linksMap.put("199207", "https://drive.google.com/file/d/1UZwpqKFroofCvyAwVZOQZMf1M4r6h6iO/view?usp=sharing");

        linksMap.put("199208", "https://drive.google.com/file/d/1L8Zn2xdBVOo-w-4sdmzkZ1iZRYoJV3hm/view?usp=sharing");

        linksMap.put("199209", "https://drive.google.com/file/d/1O8w8g7nyb9F6CO2p6ZNOQT1qxnOV1V3h/view?usp=sharing");

        linksMap.put("199210", "https://drive.google.com/file/d/1U75mO9CV_3nRRLmwEgVTA2fuCyk5DPvI/view?usp=sharing");

        linksMap.put("199211", "https://drive.google.com/file/d/1vIQF6rM2kyop-PeqYcnrWHLQNyaeHfcG/view?usp=sharing");

        linksMap.put("199212", "https://drive.google.com/file/d/1oENyGQFzBbZnXQtuJ4mCEw0ORe8SHIZo/view?usp=sharing");

        linksMap.put("19930102", "https://drive.google.com/file/d/1H9kAfX3t30Ccm6dhT8DZPUk0vvkZIxF7/view?usp=sharing");

        linksMap.put("19930304", "https://drive.google.com/file/d/15rW1dLVQep7M_6TSQSfzDxhi3CVqwJ8S/view?usp=sharing");

        linksMap.put("19930910", "https://drive.google.com/file/d/19c956zbC3nbXNis3fscLKeN65kd7Et5R/view?usp=sharing");

        linksMap.put("19931112", "https://drive.google.com/file/d/1gyVGgmS0h0cQuP7ADqhDlN03knitN26m/view?usp=sharing");

        linksMap.put("199401", "https://drive.google.com/file/d/1iegKhf0jyz88_4PMb0iZf1I4M08eZ4bf/view?usp=sharing");

        linksMap.put("199402", "https://drive.google.com/file/d/1In1GTkqYEgfxqnjFOwxGoECRC_DVQXXQ/view?usp=sharing");

        linksMap.put("199403", "https://drive.google.com/file/d/1uhzX9WkFzVWWJb3S4xkJHIuTTyVnPfEv/view?usp=sharing");

        linksMap.put("199404", "https://drive.google.com/file/d/1qIS92q5NoDYCXqUzV2FX2e_w0ACeMY_v/view?usp=sharing");

        linksMap.put("199405", "https://drive.google.com/file/d/1jbHI1xXDUujYuyQj8NxIxUhr0FfcR1v-/view?usp=sharing");

        linksMap.put("199406", "https://drive.google.com/file/d/182qzSQrxcef6qt-Ir2yGCecDGQJWMiky/view?usp=sharing");

        linksMap.put("199501", "https://drive.google.com/file/d/1OSPOf9OqpOvLUwiBCJdDRfrF0LYGwG9G/view?usp=sharing");

        linksMap.put("199502", "https://drive.google.com/file/d/1pHh6L5jDtGnrgFrcyeOxSxUKhWDA1jJ5/view?usp=sharing");

        linksMap.put("199503", "https://drive.google.com/file/d/1hkRIgiKxsz0O98GoKrNV7OXfURydH-bC/view?usp=sharing");

        linksMap.put("199504", "https://drive.google.com/file/d/18CWIDVHwc3KG-G6n7y2fP6mbYtnfV4GH/view?usp=sharing");

        linksMap.put("199505", "https://drive.google.com/file/d/1KzwHDvnKmNmbNga87ZQjL7fIfW_C3zBB/view?usp=sharing");

        linksMap.put("199506", "https://drive.google.com/file/d/1bq62CkbCoqGLpo1kVMlPVdd1illKQiB1/view?usp=sharing");

        linksMap.put("199601", "https://drive.google.com/file/d/1xElvcT8G0yRKUivdQk-JOYYx3Fvja2-f/view?usp=sharing");

        linksMap.put("199602", "https://drive.google.com/file/d/1Ae6W1BQ-CrnZz9J87gUkjTIWn40Oc4Pm/view?usp=sharing");

        linksMap.put("199603", "https://drive.google.com/file/d/1u5zrHKKnvmwUYQaCko3tfgFbu8J2m68K/view?usp=sharing");

        linksMap.put("199604", "https://drive.google.com/file/d/1lVoBaCKMSBu7bHDUE7ym1gq_hYpcir1Z/view?usp=sharing");

        linksMap.put("199605", "https://drive.google.com/file/d/1_kCzw4Mp1HBd_7hSgoknoZ8cBkS_tLzz/view?usp=sharing");

        linksMap.put("199606", "https://drive.google.com/file/d/1SgBz78crx-U-S4MBryH8dFbRsITxEXaI/view?usp=sharing");

        linksMap.put("199701", "https://drive.google.com/file/d/1defvhoGX1gzqssk_hEJ7kHvltmK9pLGE/view?usp=sharing");

        linksMap.put("199702", "https://drive.google.com/file/d/12s9uX2eNT67PNQp9BsA1hiZthpwf6F7Y/view?usp=sharing");

        linksMap.put("199703", "https://drive.google.com/file/d/1OZr5qXR1BrkiQmlDWSqW4FqurQfDEGms/view?usp=sharing");

        linksMap.put("199704", "https://drive.google.com/file/d/1De9fQ_0Q4QmGKtb9gDghKQUXO4UDnZQp/view?usp=sharing");

        linksMap.put("199705", "https://drive.google.com/file/d/1ErDxDxLpClBzqOJtHObZYidpID8HWf1W/view?usp=sharing");

        linksMap.put("199706", "https://drive.google.com/file/d/1D7pFxEJleGzBZp4LuLsY9ULpklkJ2wMo/view?usp=sharing");

        linksMap.put("199801", "https://drive.google.com/file/d/1vr57NG7BlThQmHRaGqNQjPfunb0EUaxY/view?usp=sharing");

        linksMap.put("199802", "https://drive.google.com/file/d/1cbITX4LFl60Qf2DRattuH9hha1hkiKCS/view?usp=sharing");

        linksMap.put("199803", "https://drive.google.com/file/d/1nGHE3RWzMvd-VdYhzJ145lmx72aJrFsT/view?usp=sharing");

        linksMap.put("199804", "https://drive.google.com/file/d/1Ov6QZThq7kyqiYhH21HHY26wg1xVAOOF/view?usp=sharing");

        linksMap.put("199805", "https://drive.google.com/file/d/1Qa-HiJyeVG-zjp1xw7UFhXTHxxMgWEeB/view?usp=sharing");

        linksMap.put("199806", "https://drive.google.com/file/d/1uvOygUDmh0kcR7AHqQJcxW8EoBoWfvRB/view?usp=sharing");

        linksMap.put("199901", "https://drive.google.com/file/d/1XCEs4csI3LdSicfkDofL3kt9ex18IILT/view?usp=sharing");

        linksMap.put("199902", "https://drive.google.com/file/d/1N4nAsGVbD_2n0arBVgdPLw2jKGdBKfZc/view?usp=sharing");

        linksMap.put("199903", "https://drive.google.com/file/d/1Hwo5TW4zAodZ5z_QPnEjy-DLxUO_LUod/view?usp=sharing");

        linksMap.put("199904", "https://drive.google.com/file/d/1h3Gsm2_WaYntVm9ltfENfabu2ZZn29GR/view?usp=sharing");

        linksMap.put("199905", "https://drive.google.com/file/d/1AagxitCb6Rv3Uf5HP8bYSIEhhte_zadQ/view?usp=sharing");

        linksMap.put("199906", "https://drive.google.com/file/d/1V26hjULkkm-I0E2sMXoKqrgPFXW6z1_s/view?usp=sharing");

        linksMap.put("200001", "https://drive.google.com/file/d/1WL_QIezsLh6UTGr_xDNBgpaZSlg2FZ49/view?usp=sharing");

        linksMap.put("200002", "https://drive.google.com/file/d/1a9tFD6OjN-78knbAuICp-gPbRgRrqas9/view?usp=sharing");

        linksMap.put("200003", "https://drive.google.com/file/d/1cYobQQ4N8-FjxDhIBaMNz9MqjSW-tk0L/view?usp=sharing");

        linksMap.put("200004", "https://drive.google.com/file/d/1W3BA8FFTvWRoABotXserNIjPu26enpA9/view?usp=sharing");

        linksMap.put("200005", "https://drive.google.com/file/d/1_c7USfwlBJ0m1qxtW6pAmCCgUaEt48Rr/view?usp=sharing");

        linksMap.put("200006", "https://drive.google.com/file/d/1Lzej3MFTKZGdXftIxzNJxleR5_XZlwj1/view?usp=sharing");

        linksMap.put("200101", "https://drive.google.com/file/d/1KonypKQmP9TILn9SL3_8e0ld6bggFcUu/view?usp=sharing");

        linksMap.put("200102", "https://drive.google.com/file/d/1xZz7UQsni8DZdsc9HtOqG1lQuOqvat2d/view?usp=sharing");

        linksMap.put("200103", "https://drive.google.com/file/d/1rSQ8sB6VBU2ZrKGJCeoseYaKRgugszzX/view?usp=sharing");

        linksMap.put("200104", "https://drive.google.com/file/d/1tvWjJRm-37AO4F2nNdPQZP8lrWUzQt50/view?usp=sharing");

        linksMap.put("200105", "https://drive.google.com/file/d/1msxQwno-gsQOfptB0cQlCmFocXQ2N8ki/view?usp=sharing");

        linksMap.put("200106", "https://drive.google.com/file/d/1Ct85k6Pbca9HtdKFM-pdoxh9a-olcHje/view?usp=sharing");

        linksMap.put("200201", "https://drive.google.com/file/d/1mYW3Ccy7XTi3usIGmBYnDAvmPLsmpy58/view?usp=sharing");

        linksMap.put("200202", "https://drive.google.com/file/d/15i0TvtYGLFHgmsHFjIsCJPq3Xre78UFf/view?usp=sharing");

        linksMap.put("200203", "https://drive.google.com/file/d/1f6Zzz7N2ANy3NfyCUq_tuSZpm9ovy2Xf/view?usp=sharing");

        linksMap.put("200204", "https://drive.google.com/file/d/1o5PkRP5nwdKGV0sf_tMhX_AJsYUJZama/view?usp=sharing");

        linksMap.put("200205", "https://drive.google.com/file/d/1kZcbqs0ygde2xa8bH1BrzBvOA0R0ViSJ/view?usp=sharing");

        linksMap.put("200206", "https://drive.google.com/file/d/1X_Jcvp6r9VSDwlidsmE_eApmk4cXr6v8/view?usp=sharing");

        linksMap.put("200301", "https://drive.google.com/file/d/11y4QdBMqMRxHj02R_Nnvl83LvP-jFUHV/view?usp=sharing");

        linksMap.put("200302", "https://drive.google.com/file/d/1NrNJpOta9u28YDcTf1pY1UNA3QxxK5s8/view?usp=sharing");

        linksMap.put("200303", "https://drive.google.com/file/d/1SGl-Qvu2fZ_4tcgcLHoBZF3NvSBLUzF4/view?usp=sharing");

        linksMap.put("200304", "https://drive.google.com/file/d/1gSrA3-hUcZLLF86ENQAWCs9WC2u46QID/view?usp=sharing");

        linksMap.put("200305", "https://drive.google.com/file/d/1viMO9HdouiGNpzUesU5HK8awcS1gf9qF/view?usp=sharing");

        linksMap.put("200306", "https://drive.google.com/file/d/1F5a71beAilQqBRWnwWqLDqDE_FAL-RSf/view?usp=sharing");

        linksMap.put("200401", "https://drive.google.com/file/d/1DoTznwKqn1nlNlIIo3jmDUNgwYHGcePp/view?usp=sharing");

        linksMap.put("200402", "https://drive.google.com/file/d/1qLF6Fo8Nv7gE6lHNtw426VMU5mzEVEDs/view?usp=sharing");

        linksMap.put("200403", "https://drive.google.com/file/d/1ZOFBSTIIlbQxNaA3kyt_Pf7zGXvVBPnl/view?usp=sharing");

        linksMap.put("200404", "https://drive.google.com/file/d/1mqfYyHUVS2FwZzFus6pE9cc5IJh0emST/view?usp=sharing");

        linksMap.put("200405", "https://drive.google.com/file/d/1TI2Uso4_45K3YXbE-IvT9eq86COfsOwn/view?usp=sharing");

        linksMap.put("200406", "https://drive.google.com/file/d/1zjB1DRlU2FxTQczU-CACa-z7VY3MQlD1/view?usp=sharing");

        linksMap.put("200502", "https://drive.google.com/file/d/1T63p1ZsYpTEGm6MnyQvo9MDfafajp6Va/view?usp=sharing");
        linksMap.put("200503", "https://drive.google.com/file/d/17_1nuAiR9OeK2f7hQAx2A5vuXDJFa3B6/view?usp=sharing");
        linksMap.put("200504", "https://drive.google.com/file/d/1_Ln6QAIHwG18YwLPy2S9QwrOc7XZbcl2/view?usp=sharing");
        linksMap.put("200505", "https://drive.google.com/file/d/15HWv6bLlaH7-6DCeUXNPR5RbOysalFc6/view?usp=sharing");
        linksMap.put("200506", "https://drive.google.com/file/d/1ULHb41rgw-fYEKdEVokDzA39v7Behtdi/view?usp=sharing");
        linksMap.put("200601", "https://drive.google.com/file/d/1LNWgJobLY7K9qeUqS8ym54RrY_uGtdve/view?usp=sharing");
        linksMap.put("200602", "https://drive.google.com/file/d/1NI4QER0Dm4x72_FNINJCP9gEEK7_gVvy/view?usp=sharing");
        linksMap.put("200603", "https://drive.google.com/file/d/1zIG4oRMYk9iFA9vNaVSf4PaChjTXakmM/view?usp=sharing");
        linksMap.put("200604", "https://drive.google.com/file/d/1h3nneQfphXZHTnVhocNWjP6U2rXubuVU/view?usp=sharing");
        linksMap.put("200605", "https://drive.google.com/file/d/1hJf-x9tn1yfS1UWYFcO1T64y7ymY4sbX/view?usp=sharing");
        linksMap.put("200606", "https://drive.google.com/file/d/1Z3z1t6bHGOJITIT3LsS2OJioRydIMxUB/view?usp=sharing");
        linksMap.put("200701", "https://drive.google.com/file/d/1qeOeafueGx05-aFkWzUJ4MS4qVrCCUqh/view?usp=sharing");
        linksMap.put("200702", "https://drive.google.com/file/d/19Wn5wCAyFhfpDvWR2RyVSbNLafAkwrdo/view?usp=sharing");
        linksMap.put("200703", "https://drive.google.com/file/d/1PBue0LE7vka9tcb56g_D6pgCOMUI2h1N/view?usp=sharing");
        linksMap.put("200704", "https://drive.google.com/file/d/1zNP0huHFSgRjdZlx23DkCVTIDtt2Eb_f/view?usp=sharing");
        linksMap.put("200705", "https://drive.google.com/file/d/1T-mvoq5-JZbB9HTFz0El5qkBYSqLZU26/view?usp=sharing");
        linksMap.put("200706", "https://drive.google.com/file/d/1Tzapxc2P-SHOoKTqGqY-6ESKH_uU-EYY/view?usp=sharing");
        linksMap.put("200801", "https://drive.google.com/file/d/1gFfzvfFx8Ij5Z4h1VBOFIMBj_0hQl22p/view?usp=sharing");
        linksMap.put("200802", "https://drive.google.com/file/d/1cQVfnaxldruKnPVU4gzk6iSoRmFSduKt/view?usp=sharing");
        linksMap.put("200803", "https://drive.google.com/file/d/1weAodAaRP6jScIMUQH649omqhYNxNSMk/view?usp=sharing");
        linksMap.put("200804", "https://drive.google.com/file/d/13PCm4WFgrqlWdzxp2oL1dxzdaunfyY4M/view?usp=sharing");
        linksMap.put("200805", "https://drive.google.com/file/d/1pluQWjwGQyg8abn2IVhArl2mWbNmwIhe/view?usp=sharing");
        linksMap.put("200806", "https://drive.google.com/file/d/1sv--ueesj_tMHtvgQPalZYgrfSZXpaDn/view?usp=sharing");
        linksMap.put("200901", "https://drive.google.com/file/d/1hfOBg1zygn8ivykj6vyTDEwjIMd2OVcQ/view?usp=sharing");
        linksMap.put("200902", "https://drive.google.com/file/d/1jdzwZuPohaxZphLnhVdFUHrz4430n698/view?usp=sharing");
        linksMap.put("200903", "https://drive.google.com/file/d/1AtOZ9ip2lgTOcslNDXsT1E5JcU_RcFF5/view?usp=sharing");
        linksMap.put("200904", "https://drive.google.com/file/d/1uAeQKFPv4jMOI0EbnnbBFnxL0LutKEwv/view?usp=sharing");
        linksMap.put("200905", "https://drive.google.com/file/d/1ufrhIDKvwxKrukT5B4mmRNuUknvpP_gq/view?usp=sharing");
        linksMap.put("200906", "https://drive.google.com/file/d/1E7GUPQ1DMROxdqq92nhbvTDGS3zOQ8_x/view?usp=sharing");
        linksMap.put("201001", "https://drive.google.com/file/d/13AFfg4iMlW1FdLovbY3HXxYhwhIoPO0a/view?usp=sharing");
        linksMap.put("201002", "https://drive.google.com/file/d/1mw_wK1IWPFxg1JjCcdq2O0FHvhSWhwZ6/view?usp=sharing");
        linksMap.put("201003", "https://drive.google.com/file/d/1OLge7Oh4oz3xaL-vkJK7uCS_sC4TgMQh/view?usp=sharing");
        linksMap.put("201004", "https://drive.google.com/file/d/1i5aggfRFONLVr9uPjjqoSZL5gu0KcfjT/view?usp=sharing");
        linksMap.put("201005", "https://drive.google.com/file/d/1sf_9Cx1GTcqQL3on9x1Pc-rxOGbaSxDl/view?usp=sharing");
        linksMap.put("201006", "https://drive.google.com/file/d/1Qh2Nwdasgbj1loIodEwaoDrxQ_aJrre5/view?usp=sharing");
        linksMap.put("201201", "https://drive.google.com/file/d/1SsjT1L_2ARMNU2h49EVy99VwY1KYbKAd/view?usp=sharing");
        linksMap.put("201202", "https://drive.google.com/file/d/1BOReeFhf2_E2dWAvtxRN9KGr77QdTnkx/view?usp=sharing");
        linksMap.put("201203", "https://drive.google.com/file/d/1E_Q_U3SXvNhHFNJgU4BNhnOVgce2zd8y/view?usp=sharing");
        linksMap.put("201204", "https://drive.google.com/file/d/1Md0Fcg3bKo7B2ws0kyi2IEkCk6qmNg6D/view?usp=sharing");
        linksMap.put("201256", "https://drive.google.com/file/d/1sGDqBfJ2yzCe-HBWxSU3XpaM-aEKqoBT/view?usp=sharing");
        linksMap.put("201301", "https://drive.google.com/file/d/1ObkUYBfLV-crCCnVto2YAQ3Asg_IVkUV/view?usp=sharing");
        linksMap.put("201302", "https://drive.google.com/file/d/1DcoPZUQlKElknLYFmEZcZWXGjHGGjplL/view?usp=sharing");
        linksMap.put("201303", "https://drive.google.com/file/d/1IduUJEhRy_NcQiIki67hx-S4xWFQ-TrK/view?usp=sharing");
        linksMap.put("201304", "https://drive.google.com/file/d/1N3z4AMR8xpnjc5gYq3Rqdjhkcwval5ae/view?usp=sharing");
        linksMap.put("201356", "https://drive.google.com/file/d/1aXlIOMF8o9Riyd6fzdYImIOOYAABneTi/view?usp=sharing");
        linksMap.put("201401", "https://drive.google.com/file/d/1wgGr_gG9PYkMeJiRAK_-MSmwJtRVkibV/view?usp=sharing");
        linksMap.put("201402", "https://drive.google.com/file/d/1IZg-mpxqdztXqCcHuuaJM-MJuXN3EyT5/view?usp=sharing");
        linksMap.put("201403", "https://drive.google.com/file/d/1PZ3w2oCD1mlgROwsEfBuAgqW7FSrH4za/view?usp=sharing");
        linksMap.put("201404", "https://drive.google.com/file/d/1bG9d_Vs1GUCJHfWvBn9Gm9vBW7_iDKiS/view?usp=sharing");
        linksMap.put("201456", "https://drive.google.com/file/d/1wZ4FV_4WHsq9a7cScupLkgYlBWRsKW3A/view?usp=sharing");
        linksMap.put("201501", "https://drive.google.com/file/d/1WH9S12MwaNeHsKEj7RXjTvzMmBomA__C/view?usp=sharing");
        linksMap.put("201502", "https://drive.google.com/file/d/198NYQ8oVGL-o3LuM7Fx2VpvsMIQqbe_P/view?usp=sharing");
        linksMap.put("201503", "https://drive.google.com/file/d/1g8nYRrdbbGw3SGrEGEaGCfI80XD2uF8M/view?usp=sharing");
        linksMap.put("201504", "https://drive.google.com/file/d/1RMVcgXESdH1Z28Lw0KN05Ly3v2kHYNth/view?usp=sharing");
        linksMap.put("201556", "https://drive.google.com/file/d/1xudlrS-T1SwA-OVTD-JWcxpXOaYofree/view?usp=sharing");
        linksMap.put("201601", "https://drive.google.com/file/d/1N4HiA44Fxli4o3tOFFOckZG9N94hyRIo/view?usp=sharing");
        linksMap.put("201602", "https://drive.google.com/file/d/1dA-ZQd26kgR7E0P2ofuZKtpOJku-oJfy/view?usp=sharing");
        linksMap.put("201603", "https://drive.google.com/file/d/1DTtB5WSlBmexTcoDaStTNwhI_NoMdJi0/view?usp=sharing");
        linksMap.put("201604", "https://drive.google.com/file/d/1hVfJ5ZgR5AjZjMjPH3TCR9w3Uc7P7eeT/view?usp=sharing");
        linksMap.put("201656", "https://drive.google.com/file/d/1dtgEc_mS0IHJ5FYlIcgVjZWOVv5slnhn/view?usp=sharing");
        linksMap.put("201701", "https://drive.google.com/file/d/1oN-Z7CIEUObw88IIWKnzw6rf8Qhx21MB/view?usp=sharing");
        linksMap.put("201702", "https://drive.google.com/file/d/1Bd5U7fV6goJEErhkYU3SwHzs1yN4p5uj/view?usp=sharing");
        linksMap.put("201703", "https://drive.google.com/file/d/1fhlSuM64VFCpuV3fSAGZEa4nwXvYvnXS/view?usp=sharing");
        linksMap.put("201704", "https://drive.google.com/file/d/1IO9-VVsmAJIHYZlLPgv8eP0Nt6mszD81/view?usp=sharing");
        linksMap.put("201705", "https://drive.google.com/file/d/1IfhAOIzjacVWeJ-XB7Sy34JRi0hFLfe8/view?usp=sharing");
        linksMap.put("201706", "https://drive.google.com/file/d/1RlvdWHi9pjpND4-vyFS8cM1WCFvxoWrZ/view?usp=sharing");
        linksMap.put("201707", "https://drive.google.com/file/d/1h0eGWhY33_u4OOgUloYUgNPiXsILNjR7/view?usp=sharing");
        linksMap.put("201708", "https://drive.google.com/file/d/1cZ_obA3nr1VUGYJY3wrBSW999rhU9FFo/view?usp=sharing");
        linksMap.put("201709", "https://drive.google.com/file/d/1O490qFuUBtpvjRgV0SZqel8FB4jc4Mhk/view?usp=sharing");
        linksMap.put("201710", "https://drive.google.com/file/d/1j21qyyzjAnSd_dxq0XbN-IMpUa1VrLQc/view?usp=sharing");
        linksMap.put("201711", "https://drive.google.com/file/d/1tTb9sHGQ7haXTG4-I14xL5ZKLZv-E0dE/view?usp=sharing");
        linksMap.put("201712", "https://drive.google.com/file/d/1A_DTOTsGfFzFOPgAsumdH1xo4LeWMvvq/view?usp=sharing");
        linksMap.put("201801", "https://drive.google.com/file/d/1UC_8X1tbKQRm-dWF9Lg-VoH_5vfClMBq/view?usp=sharing");
        linksMap.put("201802", "https://drive.google.com/file/d/1RG7T1V1zehdUWysrj-4WEaCN5wqtG-OR/view?usp=sharing");
        linksMap.put("201803", "https://drive.google.com/file/d/1xFW2a0g1ftAKWbaEoWNGD7WfGi28dBGr/view?usp=sharing");
        linksMap.put("201804", "https://drive.google.com/file/d/1EMpcd86IOAYsxt_I2nv4hCSkNuPbUcJ4/view?usp=sharing");
        linksMap.put("201805", "https://drive.google.com/file/d/1yZ8sXiK-kN6ThlIDbDjJqFVSxlEBIcHO/view?usp=sharing");
        linksMap.put("201806", "https://drive.google.com/file/d/1Z69TIOe3OIGiQJu2jimVkZ5qzBwmZAYt/view?usp=sharing");
        linksMap.put("201807", "https://drive.google.com/file/d/1VqOQqY9j_YiM7h1nYovlJP139ELuR_cj/view?usp=sharing");
        linksMap.put("201808", "https://drive.google.com/file/d/17RMlGlXGH8wdj16kFGNuwRPr_REeMbfi/view?usp=sharing");
        linksMap.put("201809", "https://drive.google.com/file/d/1EkkBMBO-I8WV3yVyzOe3gIJ4PfFPLbav/view?usp=sharing");
        linksMap.put("201810", "https://drive.google.com/file/d/1oSbstzJu1IRNQdgh6zIbRNnzDvyGjg0y/view?usp=sharing");
        linksMap.put("201811", "https://drive.google.com/file/d/132DBi9VvV3NLNNjAj074nc7ZhXJg68ym/view?usp=sharing");
        linksMap.put("201812", "https://drive.google.com/file/d/1o8rcvVFjHxXiQO1635vzdkK2LgKgoSS_/view?usp=sharing");
        linksMap.put("201901", "https://drive.google.com/file/d/1OtZMtCO3v-bQOr-EuGhQfHrshB5bQjFE/view?usp=sharing");
        linksMap.put("201902", "https://drive.google.com/file/d/1LDMIYF9STRMN5xzOyYaJDUWOyMhQuWVM/view?usp=sharing");
        linksMap.put("201903", "https://drive.google.com/file/d/1Qm-VlC0viUPfIYwjfUH22P4oDiKhdH_w/view?usp=sharing");
        linksMap.put("201904", "https://drive.google.com/file/d/10uw59bKlaPVVMgr1lGsuw4ORT9aPrGpq/view?usp=sharing");
        linksMap.put("201905", "https://drive.google.com/file/d/1NSt_INDxv-mGgKvJAMsPD9368VqMKamC/view?usp=sharing");
        linksMap.put("201906", "https://drive.google.com/file/d/1d5lclZyHuptF-wPAqh-kZa-KGaEHqXj1/view?usp=sharing");
        linksMap.put("201907", "https://drive.google.com/file/d/1SOJKf_B9pzCa_-L4lew6YeCbGO2eOEvI/view?usp=sharing");
        linksMap.put("201908", "https://drive.google.com/file/d/1DI4cW-pNCTPO3ourlETbYVkyzuQ-cR7K/view?usp=sharing");
        linksMap.put("201909", "https://drive.google.com/file/d/1Lecy2tJniIcATA_hXh9wvQ4AOMDEvIJc/view?usp=sharing");
        linksMap.put("201910", "https://drive.google.com/file/d/1LGd0tkiuj45MbTZaHp7KI2X7sSgixxFs/view?usp=sharing");
        linksMap.put("201911", "https://drive.google.com/file/d/1Kp9cnTw4nlN6-_ZJMh8rOAIHU8EAyDDY/view?usp=sharing");
        linksMap.put("201912", "https://drive.google.com/file/d/1GnUjKwL0tQiWtQLcK2aGEe6JkmH5ziP3/view?usp=sharing");
        linksMap.put("202001", "https://drive.google.com/file/d/1CjRBJcCLWPw6rlcXryhWOWkmfwKwBg-U/view?usp=sharing");
        linksMap.put("202002", "https://drive.google.com/file/d/1Eia9lg8IHY9VI_nkMQLNvIc8xOj8jcbi/view?usp=sharing");
        linksMap.put("202003", "https://drive.google.com/file/d/13jwV9oqT04lYFZIPX6QErRmGb1TosXei/view?usp=sharing");
        linksMap.put("202004", "https://drive.google.com/file/d/1Ikd4f8DDnS3uggBG1Hxpyjf4buynr7V7/view?usp=sharing");
        linksMap.put("202005", "https://drive.google.com/file/d/1eK2emkbpKTBwcIciw7NnlDUqy2-B2NJI/view?usp=sharing");
        linksMap.put("202006", "https://drive.google.com/file/d/1OHRc08EWUFlNxmK38oxl9pGOTTz5i54-/view?usp=sharing");
        linksMap.put("202007", "https://drive.google.com/file/d/1dxT-4pzbedBMZVZdPub9zeZRX-Db2WYp/view?usp=sharing");
        linksMap.put("202008", "https://drive.google.com/file/d/1dwPIDmnRgVtS1WEe18X7liBcmggqxMX7/view?usp=sharing");
        linksMap.put("202009", "https://drive.google.com/file/d/1_bNUWe67HLFmJAZk0Mij7RMOvITehd9W/view?usp=sharing");
        linksMap.put("202010", "https://drive.google.com/file/d/1xlBRQkGZE-RDHI-0CbKTOIFNE1kBPjMr/view?usp=sharing");
        linksMap.put("20201112", "https://drive.google.com/file/d/1b6l7GYuuTi0ns0VdsEuSI4QV1ucw_iTx/view?usp=sharing");
        linksMap.put("202101", "https://drive.google.com/file/d/12WQripgvjpmvnZFIC_Sf8d2iiW7iLetX/view?usp=sharing");
        linksMap.put("202102", "https://drive.google.com/file/d/1m59iNypfqQokcCjuAqOBXxSwEA1kG2Sc/view?usp=sharing");
        linksMap.put("202103", "https://drive.google.com/file/d/1CPu5l1ZWi8riiVsdUjwhC1ccVQyfToUe/view?usp=sharing");
        linksMap.put("202104", "https://drive.google.com/file/d/1scTn8J2SRj-OLbvaCXbheN4bqrrLtvh1/view?usp=sharing");
        linksMap.put("202105", "https://drive.google.com/file/d/1QqoSOovHVH4yg7dEgJ7F1sQc0_t_vYKu/view?usp=sharing");
        linksMap.put("202106", "https://drive.google.com/file/d/1YdevW6oKMuCS93ZYrlMl9hwsNBZw3Jb7/view?usp=sharing");
        linksMap.put("202107", "https://drive.google.com/file/d/1DtW_CNSGnYcudYsscE4M9U716LLKB_Gc/view?usp=sharing");
        linksMap.put("202108", "https://drive.google.com/file/d/1fNkERFyqxhGZ76wjMmUJ-7u_HfP-TmB_/view?usp=sharing");
        linksMap.put("202109", "https://drive.google.com/file/d/1UyGFQEYJCEF1Lxy_4Z8n1Qq6NkgRtO6U/view?usp=sharing");
        linksMap.put("202110", "https://drive.google.com/file/d/1iQCO5rL58ZGtQP3ahqd0QzQM0BTW2eka/view?usp=sharing");
        linksMap.put("20211112", "https://drive.google.com/file/d/1khzWkRSX4HCvFfA4LZvvhTNywpTvvfkT/view?usp=sharing");
        linksMap.put("202201", "https://drive.google.com/file/d/1wHRAIdQ63EZeq3f3hQ7AhoAYgr7GHyJB/view?usp=sharing");
        linksMap.put("202202", "https://drive.google.com/file/d/17UzQaUqycg1qu-RHDsjN35GBpC_FeHJ6/view?usp=sharing");
        linksMap.put("202203", "https://drive.google.com/file/d/1dTRCt6CtvD9OaYwF9-GE89m6Y5uqFxyD/view?usp=sharing");
        linksMap.put("202204", "https://drive.google.com/file/d/1FtNF7OzKK0ChcWzdSM1aMsdObHLINV8r/view?usp=sharing");
        linksMap.put("202205", "https://drive.google.com/file/d/1v_GToEYSseU4gvzVQFK6uFOWS2-azlQP/view?usp=sharing");
        linksMap.put("202206", "https://drive.google.com/file/d/1D_lvgyC7ThWYgCbzyDQQYYLqmROEOv4z/view?usp=sharing");
        linksMap.put("202207", "https://drive.google.com/file/d/1skbwFet9e8yJ9wBLRdv6_R4DBP3tJq9c/view?usp=sharing");
        linksMap.put("202208", "https://drive.google.com/file/d/1eut_VP9WtN2XuMaywEUIhTukp9PEZN60/view?usp=sharing");
        linksMap.put("202209", "https://drive.google.com/file/d/1849384nUDQ-OpGEB_jRDHjD1epdAb5Wg/view?usp=sharing");
        linksMap.put("202210", "https://drive.google.com/file/d/1TjAyOdHA5LW81hFtQ6vksKPOwf2frzQ1/view?usp=sharing");
        linksMap.put("20221112", "https://drive.google.com/file/d/1YEhENYIu8GU7rfWrclH9GzlAmdvA0GaL/view?usp=sharing");
        linksMap.put("202301", "https://drive.google.com/file/d/1x9dDSaQg6jotlXcSu5Pekh1i9q1Bg4B1/view?usp=sharing");
        linksMap.put("202302", "https://drive.google.com/file/d/1bjyZIy0CpcrdpwadKpsCfyFzVsShkIxM/view?usp=sharing");
        linksMap.put("202303", "https://drive.google.com/file/d/1iS-C-YgAoGYcyMPEh3uf7AbUDmZfM5Dp/view?usp=sharing");
        linksMap.put("202304", "https://drive.google.com/file/d/1YvmCtDq_NmbkUC5YNOf3QxFexnhJJE0L/view?usp=sharing");
        linksMap.put("202305", "https://drive.google.com/file/d/1gQEMYKl49qztaDGgtWKoBWBnykdyqIPV/view?usp=sharing");
        linksMap.put("202306", "https://drive.google.com/file/d/15WkqojIXefSKt12zbtVZVA8qNvFJAvyA/view?usp=sharing");
        linksMap.put("202307", "https://drive.google.com/file/d/17PsfKzs7O0N2gk7ZwM8DsTiEMwZYOw2A/view?usp=sharing");
        linksMap.put("202308", "https://drive.google.com/file/d/12y90oNQEx6VwiN4pFfePh5t0qoPnkVLe/view?usp=sharing");
        linksMap.put("202309", "https://drive.google.com/file/d/1tM6YJJaczpxywMdjmFZAeG5_ZpthRNlx/view?usp=sharing");
        linksMap.put("202310", "https://drive.google.com/file/d/175JZl9S5gTOyRBLS72O7gzx11wRNSWi6/view?usp=sharing");
        linksMap.put("20231112", "https://drive.google.com/file/d/1VbahRmjayTpQSymJ9-9D58Yv8U6XUU_L/view?usp=sharing");
        linksMap.put("202401", "https://drive.google.com/file/d/1EFrCmvlqTYITXmXmClh8xIBQjfm8jM1h/view?usp=sharing");
        linksMap.put("202402", "https://drive.google.com/file/d/1vlTNpXk0RaT2_qgqQkL7fNFCEufr6jcK/view?usp=sharing");
        linksMap.put("202403", "https://drive.google.com/file/d/1e3S7kt3kW0JK2pEmWwRc1tBt7In3_iGQ/view?usp=sharing");

        for(int year = 1970; year <= 2024; year++){
            for(int ch = 1; ch <= 12; ch++){
                String chapter;

                if(ch < 10 && linksMap.containsKey(Integer.toString(year) + "0" + Integer.toString(ch))){
                    chapter = "0" + Integer.toString(ch);
                }
                else if(ch >= 10 && linksMap.containsKey(Integer.toString(year) + Integer.toString(ch))){
                    chapter = Integer.toString(ch);
                }
                else {
                    if(ch < 9 && linksMap.containsKey(Integer.toString(year) + "0" + Integer.toString(ch) + "0" + Integer.toString(ch + 1)))
                        chapter = "0" + Integer.toString(ch) + "0" + Integer.toString(ch + 1);
                    else if(ch == 9 && linksMap.containsKey(Integer.toString(year) + "0" + Integer.toString(ch) + Integer.toString(ch + 1)))
                        chapter = "0" + Integer.toString(ch) + Integer.toString(ch + 1);
                    else if(ch >= 10 && linksMap.containsKey(Integer.toString(year) + Integer.toString(ch) + Integer.toString(ch + 1)))
                        chapter = Integer.toString(ch) + Integer.toString(ch + 1);
                    else
                        continue;
                }

                String key = Integer.toString(year) + chapter;
                String uri = "@drawable/s" + key;
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                itemsList.add(new Item(imageResource, key));
            }

        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mAdapter = new MyAdapter(itemsList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String name) {
                Intent intent = new Intent(MainActivity.this, BrowserPdf.class);
                intent.putExtra("name", name);
                String url = linksMap.get(name);
//                if (url != null) {
//                    url = url.replace("https://drive.google.com/file/d/", "https://drive.google.com/uc?&id=");
//                }
//                if (url != null) {
//                    url = url.replace("/view?usp=sharing", "");
                //}
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}