/* Clayton Snider
12-15-2012
RPG BAttle PRototype round 2
Displays user and enemy vitals, asks for input based on options, and 
calculates and displays outputs based on inputs*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main (void)
{
	int UserHPMax, UserHP, UserDEF, UserDEX, UserAGL, UserMPMax, UserMP;
	int EnemyHPMax, EnemyHP, EnemyDEF, EnemyDEX, EnemyAGL;
	int choice, UserATTKMax,UserATTKMin, EnemyATTKMax, EnemyATTKMin, damage, Cost, SpellMax, SpellMin;

	UserHPMax = 60;
	UserMPMax = 20;
	UserDEF = 10;
	UserDEX = 8;
	UserAGL = 8;
	UserATTKMin = 10;
	UserATTKMax = 18;

	EnemyHPMax = 100;
	EnemyDEF = 10;
	EnemyDEX = 8;
	EnemyAGL = 8;
	EnemyATTKMin = 8;
	EnemyATTKMax = 15;

	UserHP = UserHPMax;
	UserMP = UserMPMax;
	EnemyHP = EnemyHPMax;

	while (UserHP > 0 && EnemyHP > 0)
	{
MENU:	printf ("Your HP: %d / %d			EnemyHP: %d / %d\n", UserHP, UserHPMax, EnemyHP, EnemyHPMax);
		printf ("Your MP: %d / %d\n\n", UserMP, UserMPMax);
	
		printf ("1- Attack\n");
		printf ("2- Magic\n");
		printf ("3- Run\n");
		printf ("What do you do?>");
		scanf ("%d", &choice);
	
	if (choice == 1)
		{
			damage = rand()%20 + 1;
			if (damage >= UserDEX)
			{
				damage = rand() %UserATTKMax + UserATTKMin;
				damage = damage - EnemyDEF;
				EnemyHP = EnemyHP - damage;
				printf ("SHWING! You deal %d damage, reducing the enemy to %d HP\n", damage, EnemyHP);
				system ("pause");
				system ("cls");
			}
			else
			{
				printf ("You swing and miss.\n");
				system ("pause");
				system ("cls");
			}


		}
	if (choice == 2)
		{
			printf ("1- Fireball\n");
			printf ("2- Heal\n");
			printf ("3- Nevermind\n");
			scanf ("%d", &choice);

			if (choice == 1)
			{
				Cost = 8;
				SpellMin = 15;
				SpellMax = 25;

				if (UserMP >= Cost)
				{
					UserMP = UserMP - Cost;
					damage = rand() % SpellMax + SpellMin;
					EnemyHP = EnemyHP - damage;
					printf ("KASWOOSH! A giant ball of fire crisps your opponent for %d damage, leaving him with %d HP and roasted hairs.\n", damage, EnemyHP);
					system ("pause");
					system ("cls");
				}
				else
				{
					printf ("No fireballs for you!\n");
					system ("pause");
					system ("cls");
					goto MENU;
				}
			
				}

			if (choice == 2)
			{
				Cost = 8;
				SpellMin = 8;
				SpellMax = 20;

				if (UserMP >= Cost)
				{
					UserMP = UserMP - Cost;
					damage = rand() % SpellMax + SpellMin;
					UserHP = UserHP + damage;
					if (UserHP > UserHPMax)
					{
						UserHP = UserHPMax;
					}
					else 
					{
						printf ("Sparklies! You recover %d HP, bringing you up to %d HP!\n", damage, UserHP);
						system ("pause");
						system ("cls");

					}
				}
				else
				{
					printf ("Sorry! No heals for you!\n");
					system ("pause");
					system ("cls");
					goto MENU;
				}
			}
			if (choice == 3)
			{
				printf ("Okay! We won't throw nifty stuff around.\n");
				system ("pause");
				system ("cls");
				goto MENU;
			}

		}
		if (choice == 3)
		{
			damage = rand() % 20 + 1;
			if (damage >= UserAGL)
			{
				printf ("You hastily prance away from the battle, you bloody pansy!\n");
				system ("pause");
				system ("cls");
				return 0;
			}
			else
			{
				printf ("Sorry, Sir Robin, no brave chickening-outs for you! Stand and fight!");
				system ("pause");
				system ("cls");
			}
		}
		damage = rand() % 20 + 1;
		if (damage >= EnemyDEX)
		{
			damage = rand() % EnemyATTKMax + EnemyATTKMin;
			damage = damage - UserDEF;
			if (damage < 0)
			{
				UserHP = UserHP - damage;
				printf ("The enemy smites you for %d damage, leaving you with a paltry %d HP\n", damage, UserHP);
			}
			else
			{
				puts ("The enemy swings his weapon, but it bounces off your armor!\n");
				break;
			}
		}
		else
		{
			printf ("The enemy swings at you and misses.\n");
			system ("pause");
			system ("cls");
			
		}
	}
	if (UserHP <= 0)
	{
		printf ("You fought reasonably bravely, but alas! 'Twas not enough!\n");
		printf ("Game Over\n");
		system ("pause");
		system ("cls");
		return 0;
	}

	if (EnemyHP <= 0)
	{
		printf ("Congratulations! The enemy has fallen! The ladies will be all upons!\n");
		system ("pause");
		system ("cls");
		return 0;
	}
}
