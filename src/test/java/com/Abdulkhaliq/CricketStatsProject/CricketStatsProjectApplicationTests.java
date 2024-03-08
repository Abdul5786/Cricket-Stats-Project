package com.Abdulkhaliq.CricketStatsProject;

import com.Abdulkhaliq.CricketStatsProject.entities.Player;
import com.Abdulkhaliq.CricketStatsProject.payloads.PlayerDto;
import com.Abdulkhaliq.CricketStatsProject.repositories.PlayerRepo;

import com.Abdulkhaliq.CricketStatsProject.services.servicesImpl.PlayerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CricketStatsProjectApplicationTests {


	@Mock
	private PlayerRepo playerRepo;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private PlayerServiceImpl playerService;






	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetPlayerById() {
		// Mocking data
		Player player = new Player();
		player.setPlayerId(1);
		player.setPlayerName("Test Player");
		when(playerRepo.findById(1)).thenReturn(Optional.of(player));

		// Mocking model mapper
		PlayerDto playerDto = new PlayerDto();
		playerDto.setPlayerId(1);
		playerDto.setPlayerName("Test Player");
		when(modelMapper.map(player, PlayerDto.class)).thenReturn(playerDto);

		// Calling the service method
		PlayerDto actualPlayerDto = playerService.getPlayerById(1);

		// Verifying the result
		assertEquals(playerDto.getPlayerId(), actualPlayerDto.getPlayerId());
		assertEquals(playerDto.getPlayerName(), actualPlayerDto.getPlayerName());
	}









}
