package com.patinfly.domain.usecase;

import android.content.Context;
import com.patinfly.data.dataSource.scooter.ScooterDao
import com.patinfly.data.repository.ScooterRepository
import com.patinfly.data.repository.UserRepository

import com.patinfly.domain.model.Scooter;
import com.patinfly.domain.repository.IScooterRepository;

class GetScootersUseCase(private var scooterRepository: ScooterRepository) {
        fun execute(context:Context): List<Scooter> {
            return scooterRepository.fetchScooters()

    }
}
