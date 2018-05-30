package net.librec.recommender.cf.rating;
import net.librec.annotation.ModelData;
import net.librec.common.LibrecException;
import net.librec.data.convertor.appender.SocialDataAppender;
import net.librec.math.structure.DenseMatrix;
import net.librec.math.structure.DenseVector;
import net.librec.math.structure.MatrixEntry;
import net.librec.math.structure.SparseMatrix;

import java.util.ArrayList;
import java.util.List;
@ModelData({"isRating", "mysvdplus", "userFactors", "itemFactors", "userBiases", "itemBiases", "impItemFactors", "trainMatrix"
        , "socialMatrix"})
/**
 * Created by wangmin on 2018/4/9.
 */
public class MySVDPlus  extends BiasedMFRecommender{

    //JaccardSimilarity
/*
        SymmMatrix    matrix data    Table<Integer, Integer, Double>

Sim  =pul -pvl

 regfactor  =0.1
 userxFactors.add(userIdx, factorIdx, learnRate * (error * itemFactorValue - regfactor*regUser * userFactorValue));


          for (int userIdx = 0; userIdx < numUsers; userIdx++) {
            int userFriendCount = socialMatrix.columnSize(userIdx);


            }



            Set<Integer>            set    =   socialMatrix.getColumnsSet(userIdx)
               int userFriendCount = socialMatrix.columnSize(userIdx);
                   for( Integer i:set)
                         userIDy  =i.intValue()
              useryFactors.add(useryIdy
              trusteeWeights.set(userId, userFriendCount > 0 ? 1.0 / Math.sqrt(userFriendCount) : 1.0)、
              trusteeWeights  为用户u的一维数组
              double trusterWeightValue = trusterWeights.get(userIdy);
trusterWeightValue * userFactorValue

trusteeFactors.addEqual(trusteeTempFactors.scale(-learnRate));
minusEqual
           socialMatrix[useridx]

sum （ useryFactors.add(useryIdy, factorIdx, (1-regfactor )    e Maxtrixx- Maxtrixy/0.2 * useryFactors.   / frirendcount(useridx))）;
 itemFactors.add(itemIdx, factorIdx, learnRate * (error * (userFactorValue + sumImpItemsFactors.get(factorIdx)) - regItem * itemFactorValue));



1.训练集有用户项目评分    好友集有用户和好友
 数据集 DataMatrix ：row col val
训练集 SparseMatrix trainMatrix          double[] rowData     int[] rowPtr, colInd   double[] colData   int[] colPtr, rowInd
 好友集 SparseMatrix socialMatrix
2.计算用户u在训练集上对隐因子的评分

DenseMatrix    [][] data   numRows, numColumns

DenseMatrix userFactors
             userFactors.add(int row, int column, double val)        userFactorValue = userFactors.get(userIdx, factorIdx);

3.在好友集中找出u的所有好友v以及好友数

         SparseMatrix socialMatrix
           MatrixEntry  可以获取稀疏矩阵的索引值
//                for (MatrixEntry socialMatrixEntry : socialMatrix)
//                 int userIdx = socialMatrixEntry.row();
//                 int trusteeIdx = socialMatrixEntry.column();
//                  double realRating = matrixEntry.get()


                for (int userIdx = 0; userIdx < numUsers; ++userIdx) //所有的user
                    List<Integer> userfriendsList = new ArrayList<>()
                   int userFriendCount = socialMatrix.columnSize(userIdx);


                   userfriendsList.add(sparseMatrix.getColumns(userIdx))




4.计算u与每个好友的相似度   u与v共同评分项目的数/u与v全部的评分项目的数

double    sim(u,v)  =
for(     Integer  userid         :  userfriendsList)


{
       int userxitemCount = trainMatrix.columnSize(userIdx);
       int  useryitemcount= trainMatrix.columnSize(userid);
       Set<Integer>  userx =   trainMaxtrix.getColumnsSet(userIdx)
       Set<Integer>  usery =   trainMaxtrix.getColumnsSet(userid)



     sim(u,v)
       Set<Integer> elements = new HashSet<Integer>();
       elements.addAll(userx)
       elements.addAll(usery)
       int numAllElements = elements.size();
       int numCommonElements = userx.size() + usery.size() - numAllElements;
       sim(u,v)=(numCommonElements + 0.0) / numAllElements
      return  sim(u,v)





5. 计算每个好友在隐向量中的评分
 double userFactorValue = userFactors.get(userIdx, factorIdx);
  for(   iInteger  useridy         :  userfriendsList)
  {
  for (int factorIdx = 0; factorIdx < numFactors; ++factorIdx)
  userFactors.add(int row, int column, double val)    ---(useridy, factorIdx ,userFactorValue )
  }





6.正则参数*  u在训练集上对隐因子的评分+（1- 正则参数*）[每个好友的相似度*每个好友的隐向量评分]



for (int factorIdx = 0; factorIdx < numFactors; ++factorIdx) {
{
                    double userFactorValue = userFactors.get(userIdx, factorIdx);
                    double itemFactorValue = itemFactors.get(itemIdx, factorIdx);

     userFactors.add(userIdx, factorIdx, learnRate * (error * regcanshu*itemFactorValue - regUser * userFactorValue));


     List<Integer> items = userItemsList.get(userIdx);


        double friendcount = 1.0/userFriendCount
             for(   Integer   userid:       userfriendsList )
              userFactorValue = userFactors.get(userid, factorIdx);
     userfactors.add( useridx,factorIdx,val : (1-  regcanshu)*  error*    friendcount*  userFactorsvalue   -     regImpuser * userFactor)





}


 */


    //以下是TrustSVDRecommender
    //trusteeFactors   ？
    //trusteeWeights



    //以下是SocialRecommender

    //socialMatrix   一个用户连接其他的用户的二维矩阵
    //regSocial

    //以下是SVDPlusPlusRecommender
    //  regImpItem
    //   impItemFactors
    // userItemsList            userItemsList = getUserItemsList(trainMatrix);


    //以下是BiasedMFRecommender
//已经有regBias  即bias regularization
    //userBiases
    //itemBiases


    //以下是abstractrecommender
    //userFactors
    //itemFactors 二元数组
    //numFactors  int
    //regUser
    //regItem
//RecommendedList

//librec rec -exec -conf ..\core\src\main\resources\rec\cf\rating\MySVDPlus-test.properties







    protected DenseMatrix impItemFactors;

    protected List<List<Integer>> userItemsList;
    protected List<List<Integer>>   userfriendsList;  //我加的

    private double regImpItem;

    private double   regpara;      //我加的

    protected SparseMatrix socialMatrix;    //这部分在socialrecommender里










    private List<List<Integer>> getUserItemsList(SparseMatrix sparseMatrix) {
        List<List<Integer>> userItemsList = new ArrayList<>();
        for (int userIdx = 0; userIdx < numUsers; ++userIdx) {
            userItemsList.add(sparseMatrix.getColumns(userIdx));
        }
        return userItemsList;
    }

    public void setup() throws LibrecException {

        super.setup();
        regImpItem = conf.getDouble("rec.impItem.regularization", 0.015d);
        regpara=conf.getDouble("rec.social.regpar", 0.015d);
        impItemFactors = new DenseMatrix(numItems, numFactors);
        impItemFactors.init(initMean, initStd);
        userItemsList = getUserItemsList(trainMatrix);

        socialMatrix = ((SocialDataAppender) getDataModel().getDataAppender()).getUserAppender();//socail里




    }



    protected void trainModel() throws LibrecException {
        for (int iter = 1; iter <= numIterations; iter++) {
            loss = 0.0d;
            for (MatrixEntry matrixEntry : trainMatrix) {

                int userIdx = matrixEntry.row(); // user
                int itemIdx = matrixEntry.column(); // item
                double realRating = matrixEntry.get();

                double predictRating = predict(userIdx, itemIdx);
                double error = realRating - predictRating;

                loss += error * error;

                List<Integer> items = userItemsList.get(userIdx);

                // update user and item bias
                double userBiasValue = userBiases.get(userIdx);
                userBiases.add(userIdx, learnRate * (error - regBias * userBiasValue));

                loss += regBias * userBiasValue * userBiasValue;

                double itemBiasValue = itemBiases.get(itemIdx);
                itemBiases.add(itemIdx, learnRate * (error - regBias * itemBiasValue));

                loss += regBias * itemBiasValue * itemBiasValue;

                DenseVector sumImpItemsFactors = new DenseVector(numFactors);
                for (int impItemIdx : items) {
                    sumImpItemsFactors.addEqual(impItemFactors.row(impItemIdx, false));
                }

                double impNor = Math.sqrt(items.size());
                if (impNor > 0) {
                    sumImpItemsFactors.scaleEqual(1.0 / impNor);
                }

                //update user and item factors
                for (int factorIdx = 0; factorIdx < numFactors; ++factorIdx) {
                    double userFactorValue = userFactors.get(userIdx, factorIdx);
                    double itemFactorValue = itemFactors.get(itemIdx, factorIdx);
                    double deltaUser = error * itemFactorValue*regpara - regUser * userFactorValue;
                    double deltaItem1= error * (regpara*userFactorValue + sumImpItemsFactors.get(factorIdx)) - regItem * itemFactorValue;
                    List<Integer> userfriendsList = new ArrayList();

                    userfriendsList.addAll(socialMatrix.getColumns(userIdx));
                    int userFriendCount = socialMatrix.columnSize(userIdx);
                    double deltaItem2=0.0;
                    for(   Integer   userid:       userfriendsList ) {
                        userFactorValue = userFactors.get(userid, factorIdx);
                        deltaItem2 +=(1-regpara)*userFactorValue;

                    }
                    deltaItem2/=userFriendCount;


                    userFactors.add(userIdx, factorIdx, learnRate * (error * deltaUser));
                    itemFactors.add(itemIdx, factorIdx, learnRate * (deltaItem1+deltaItem2));

                    loss += regUser * userFactorValue * userFactorValue + regItem * itemFactorValue * itemFactorValue;

                    for (int impItemIdx : items) {
                        double impItemFactor = impItemFactors.get(impItemIdx, factorIdx);
                        impItemFactors.add(impItemIdx, factorIdx, learnRate * (error * itemFactorValue / impNor - regImpItem * impItemFactor));

                        loss += regImpItem * impItemFactor * impItemFactor;
                    }








                }
            }
            loss *= 0.5d;

//            if (isConverged(iter) && earlyStop) {
//                break;
//            }
            updateLRate(iter);
        }
    }







    @Override
    protected double predict(int userIdx, int itemIdx) throws LibrecException {
        double predictRating = userBiases.get(userIdx) + itemBiases.get(itemIdx) + globalMean;

        List<Integer> items = userItemsList.get(userIdx);
        DenseVector userImpFactor = new DenseVector(numFactors);

        // sum of implicit feedback factors of userIdx with weight Math.sqrt(1.0 / userItemsList.get(userIdx).size())
        for (int impItemIdx : items) {
            userImpFactor.addEqual(impItemFactors.row(impItemIdx, false));
        }

        double impNor = Math.sqrt(items.size());
        if (impNor > 0) {
            userImpFactor.scaleEqual(1.0 / impNor);
        }
        // sum with user factors
        userImpFactor.addEqual(userFactors.row(userIdx, false));

        return predictRating + userImpFactor.inner(itemFactors.row(itemIdx, false));
    }

}
