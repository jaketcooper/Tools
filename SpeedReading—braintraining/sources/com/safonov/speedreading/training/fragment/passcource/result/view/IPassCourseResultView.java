package com.safonov.speedreading.training.fragment.passcource.result.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import java.util.List;

public interface IPassCourseResultView extends MvpView {
    void addEvenNumbersResultView(EvenNumbersResult evenNumbersResult, List<EvenNumbersResult> list);

    void addGreenDotResultView(GreenDotResult greenDotResult);

    void addLineOfSightResultView(LineOfSightResult lineOfSightResult, List<LineOfSightResult> list);

    void addPassCourseResultView(PassCourseResult passCourseResult, List<PassCourseResult> list);

    void addRememberNumberResultView(RememberNumberResult rememberNumberResult, List<RememberNumberResult> list);

    void addSchulteTableResultView(List<SchulteTableResult> list, List<SchulteTableResult> list2);

    void addSpeedReadingResultView(SpeedReadingResult speedReadingResult, List<SpeedReadingResult> list);

    void addWordPairsResultView(WordPairsResult wordPairsResult, List<WordPairsResult> list);

    void dismissProgressDialog();

    void showProgressDialog();
}
