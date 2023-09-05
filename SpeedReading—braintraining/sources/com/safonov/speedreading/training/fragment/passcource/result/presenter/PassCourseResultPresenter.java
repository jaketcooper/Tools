package com.safonov.speedreading.training.fragment.passcource.result.presenter;

import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.evennumbers.repository.IEvenNumberRepository;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.greendot.repository.IGreenDotRepository;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.lineofsight.repository.ILineOfSightRepository;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.passcource.repository.IPassCourseRepository;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import com.safonov.speedreading.training.fragment.passcource.result.view.IPassCourseResultView;
import com.safonov.speedreading.training.fragment.passcource.util.EvenNumbersScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.GreenDotScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.LineOfSightScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.RememberNumberScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.SchulteTableScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.SpeedReadingScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.WordPairsScoreUtil;
import com.safonov.speedreading.training.fragment.remembernumber.repository.IRememberNumberRepository;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import com.safonov.speedreading.training.fragment.schultetable.repository.ISchulteTableRepository;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.speedreading.repository.ISpeedReadingRepository;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.wordpairs.repository.IWordPairsRepository;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import com.safonov.speedreading.training.util.ResultListUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PassCourseResultPresenter extends MvpBasePresenter<IPassCourseResultView> implements IPassCourseResultPresenter {
    private static final int PASS_COURSE_1_TYPE = 1;
    private IEvenNumberRepository evenNumberRepository;
    private IGreenDotRepository greenDotRepository;
    private ILineOfSightRepository lineOfSightRepository;
    /* access modifiers changed from: private */
    public IPassCourseRepository passCourseRepository;
    private IRememberNumberRepository rememberNumberRepository;
    private ISchulteTableRepository schulteTableRepository;
    private ISpeedReadingRepository speedReadingRepository;
    private IWordPairsRepository wordPairsRepository;

    public PassCourseResultPresenter(@NonNull IPassCourseRepository passCourseRepository2, @NonNull ISchulteTableRepository schulteTableRepository2, @NonNull IRememberNumberRepository rememberNumberRepository2, @NonNull ILineOfSightRepository lineOfSightRepository2, @NonNull ISpeedReadingRepository speedReadingRepository2, @NonNull IEvenNumberRepository evenNumberRepository2, @NonNull IWordPairsRepository wordPairsRepository2, @NonNull IGreenDotRepository greenDotRepository2) {
        this.passCourseRepository = passCourseRepository2;
        this.schulteTableRepository = schulteTableRepository2;
        this.lineOfSightRepository = lineOfSightRepository2;
        this.rememberNumberRepository = rememberNumberRepository2;
        this.speedReadingRepository = speedReadingRepository2;
        this.evenNumberRepository = evenNumberRepository2;
        this.wordPairsRepository = wordPairsRepository2;
        this.greenDotRepository = greenDotRepository2;
    }

    public void init(int[] resultIds) {
        if (isViewAttached()) {
            ((IPassCourseResultView) getView()).showProgressDialog();
        }
        int[] schulteTable1ResultIds = Arrays.copyOfRange(resultIds, 0, 5);
        int[] schulteTable2ResultIds = Arrays.copyOfRange(resultIds, 10, 15);
        final List<SchulteTableResult> schulteTable1ResultList = getShulteTableResultList(schulteTable1ResultIds);
        final RememberNumberResult rememberNumber1Result = this.rememberNumberRepository.getResult(resultIds[5]);
        final LineOfSightResult lineOfSight1Result = this.lineOfSightRepository.getResult(resultIds[6]);
        final SpeedReadingResult speedReading1Result = this.speedReadingRepository.getResult(resultIds[7]);
        final WordPairsResult wordPairsResult = this.wordPairsRepository.getResult(resultIds[8]);
        final EvenNumbersResult evenNumbersResult = this.evenNumberRepository.getResult(resultIds[9]);
        final List<SchulteTableResult> schulteTable2ResultList = getShulteTableResultList(schulteTable2ResultIds);
        final RememberNumberResult rememberNumber2Result = this.rememberNumberRepository.getResult(resultIds[15]);
        final LineOfSightResult lineOfSight2Result = this.lineOfSightRepository.getResult(resultIds[16]);
        final LineOfSightResult lineOfSight3Result = this.lineOfSightRepository.getResult(resultIds[17]);
        final SpeedReadingResult speedReading2Result = this.speedReadingRepository.getResult(resultIds[18]);
        final GreenDotResult greenDotResult = this.greenDotRepository.getResult(resultIds[19]);
        int passCourseScore = 0;
        if (schulteTable1ResultList != null) {
            passCourseScore = 0 + getSchulteTablePassCourseScore(schulteTable1ResultList);
        }
        if (schulteTable2ResultList != null) {
            passCourseScore += getSchulteTablePassCourseScore(schulteTable2ResultList);
        }
        if (!(rememberNumber1Result == null || rememberNumber2Result == null)) {
            passCourseScore += getRememberPassCourseScore(rememberNumber1Result, rememberNumber2Result);
        }
        if (!(speedReading1Result == null || speedReading2Result == null)) {
            passCourseScore += getSpeedReadingPassCourseScore(speedReading1Result, speedReading2Result);
        }
        if (!(lineOfSight1Result == null || lineOfSight2Result == null || lineOfSight3Result == null)) {
            passCourseScore += getLineOfSightPassCourseScore(lineOfSight1Result, lineOfSight2Result, lineOfSight3Result);
        }
        if (wordPairsResult != null) {
            passCourseScore += WordPairsScoreUtil.getPassCourseScore(wordPairsResult.getScore());
        }
        if (evenNumbersResult != null) {
            passCourseScore += EvenNumbersScoreUtil.getPassCourseScore(evenNumbersResult.getScore());
        }
        if (greenDotResult != null) {
            passCourseScore += GreenDotScoreUtil.getPassCourseScore(greenDotResult.getConfig().getDuration());
        }
        PassCourseResult passCourseResult = new PassCourseResult();
        passCourseResult.setScore(passCourseScore);
        passCourseResult.setType(1);
        passCourseResult.setUnixTime(System.currentTimeMillis());
        this.passCourseRepository.addResult(passCourseResult, new IPassCourseRepository.OnTransactionCallback() {
            public void onTransactionCompleted(int id) {
                PassCourseResult passCourseResult = PassCourseResultPresenter.this.passCourseRepository.getResult(id);
                List<PassCourseResult> chartList = PassCourseResultPresenter.this.passCourseRepository.getResultList();
                if (PassCourseResultPresenter.this.isViewAttached()) {
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addSchulteTableResultView(schulteTable1ResultList, (List<SchulteTableResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addRememberNumberResultView(rememberNumber1Result, (List<RememberNumberResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addLineOfSightResultView(lineOfSight1Result, (List<LineOfSightResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addSpeedReadingResultView(speedReading1Result, (List<SpeedReadingResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addWordPairsResultView(wordPairsResult, (List<WordPairsResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addEvenNumbersResultView(evenNumbersResult, (List<EvenNumbersResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addSchulteTableResultView(schulteTable2ResultList, (List<SchulteTableResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addRememberNumberResultView(rememberNumber2Result, (List<RememberNumberResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addLineOfSightResultView(lineOfSight2Result, (List<LineOfSightResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addLineOfSightResultView(lineOfSight3Result, (List<LineOfSightResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addSpeedReadingResultView(speedReading2Result, (List<SpeedReadingResult>) null);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addGreenDotResultView(greenDotResult);
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).addPassCourseResultView(passCourseResult, ResultListUtil.getLastPartOfList(chartList));
                    ((IPassCourseResultView) PassCourseResultPresenter.this.getView()).dismissProgressDialog();
                }
            }
        });
    }

    private List<SchulteTableResult> getShulteTableResultList(@NonNull int[] resultIds) {
        List<SchulteTableResult> resultList = new ArrayList<>();
        for (int id : resultIds) {
            resultList.add(this.schulteTableRepository.getResult(id));
        }
        return resultList;
    }

    private int getSchulteTablePassCourseScore(@NonNull List<SchulteTableResult> resultList) {
        int passCourseScore = 0;
        for (SchulteTableResult result : resultList) {
            if (result != null) {
                passCourseScore += SchulteTableScoreUtil.getPassCourseScore(result.getTime());
            }
        }
        return passCourseScore;
    }

    private int getLineOfSightPassCourseScore(@NonNull LineOfSightResult... results) {
        int passCourseScore = 0;
        for (LineOfSightResult result : results) {
            if (result != null) {
                passCourseScore += LineOfSightScoreUtil.getPassCourseScore(result.getMistakeCount(), result.getFoundMistakeCount());
            }
        }
        return passCourseScore;
    }

    private int getSpeedReadingPassCourseScore(@NonNull SpeedReadingResult... results) {
        int passCourseScore = 0;
        for (SpeedReadingResult result : results) {
            if (result != null) {
                passCourseScore += SpeedReadingScoreUtil.getPassCourseScore(result.getMaxSpeed());
            }
        }
        return passCourseScore;
    }

    private int getRememberPassCourseScore(@NonNull RememberNumberResult... results) {
        int passCourseScore = 0;
        for (RememberNumberResult result : results) {
            if (result != null) {
                passCourseScore += RememberNumberScoreUtil.getPassCourseScore(result.getScore());
            }
        }
        return passCourseScore;
    }
}
