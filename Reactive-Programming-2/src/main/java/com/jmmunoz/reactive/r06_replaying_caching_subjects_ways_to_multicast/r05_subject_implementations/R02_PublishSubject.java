package com.jmmunoz.reactive.r06_replaying_caching_subjects_ways_to_multicast.r05_subject_implementations;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class R02_PublishSubject {

    public static void main(String[] args) {

        Subject<String> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println("Subscriber 1: " + e));

        subject.onNext("a");
        subject.onNext("b");
        subject.onNext("c");

        subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

        subject.onNext("d");
        subject.onNext("e");
        subject.onComplete();
    }
}
