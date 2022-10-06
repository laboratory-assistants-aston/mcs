package ru.aston.mcs.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.aston.mcs.dto.UserDTO;
import ru.aston.mcs.entity.User;
import ru.aston.mcs.repository.UserRepository;
import ru.aston.mcs.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @SpyBean
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = new User(1L, 123, "validUser", "email", null);
        User user2 = new User(2L, 1234, "validUser1", "email1", null);
        User user3 = new User(3L, 12345, "validUser2", "email2", null);
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findAll()).thenReturn(List.of(user, user2, user3));
    }

    @Test
    public void whenValidId_thenUserShouldBeFound() {
        Long id = 1L;
        UserDTO found = userService.getUser(1L);

        assertThat(found.getId()).isEqualTo(id);
    }
    @Test
    public void whenFindAll_then3UsersShouldBeFound() {
        List<UserDTO> userList = userService.getAllUsers();

        assertThat(userList).isNotNull();
        assertThat(userList.size()).isEqualTo(3);
    }

    @Test
    public void whenDeleteById_thenNothingShouldReturn() {
        long id = 1L;

        willDoNothing().given(userRepository).deleteById(id);

        userService.deleteUser(id);

        verify(userRepository, times(1)).deleteById(id);
    }

    @Test(expected = RuntimeException.class)
    public void whenInvalidId_thenThrowException() {
        Long id = 0L;
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty());
        UserDTO found = userService.getUser(0L);
        verify(userRepository, times(1)).findById(id);
    }
}
