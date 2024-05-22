package com.clevertigroup.democris.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Nested
    @DisplayName("When find All Users is called")
    class FindAll {
        @Test
        @DisplayName("but the database is empty should return an empty array")
        void getAllUsersInDataBase() {
            Mockito.when(userRepository.findAll())
                    .thenReturn(List.of());

            List<User> users = userService.getAll();
            assertEquals(0, users.size());
        }

        @Test
        @DisplayName("should return what is inside the database")
        void databaseWithSomething() {
            Mockito.when(userRepository.findAll())
                    .thenReturn(List.of(

                            new User(null, "test", "test", "test", LocalDateTime.now(), LocalDate.now())

                    ));
            List<User> all = userService.getAll();

            assertEquals(1, all.size());


        }
    }


}